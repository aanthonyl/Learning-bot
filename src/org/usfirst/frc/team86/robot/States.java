package org.usfirst.frc.team86.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

public class States {
	private Solenoid leftSole;
	private Solenoid rightSole;
	private TalonSRX left;
	private TalonSRX right;
	private int state = 0;
	private double initTime = Time.getTime();

	public States(Solenoid lsol, Solenoid rsol, TalonSRX left, TalonSRX right){
		//objects defined at the top are set to the ones we passed in
		leftSole = lsol;
		rightSole = rsol;
		this.left = left;
		this.right = right;
	}
	
	public void init(){
		//set everything to 0
		left.set(ControlMode.PercentOutput, 0);
		right.set(ControlMode.PercentOutput, 0);
		left.setSelectedSensorPosition(0, 0, 0);
		right.setSelectedSensorPosition(0, 0, 0);
		leftSole.set(false);
		rightSole.set(false);
	}
	
	public void states(){
		switch(state){
		case 0:
			//runs only once, to get the time at the start
			initTime = Time.getTime();
			state = 1;
			break;
		case 1:
			//for 5 seconds, go forward at 50%
			left.set(ControlMode.PercentOutput, .5);
			right.set(ControlMode.PercentOutput, -.5);
			//if the current time minus the starting time is greater or equal to 5 
			if(Time.getTime()- initTime >= 5){
				//resets initial time to the current time
				initTime = Time.getTime();
				state = 2;
			}
			break;
		case 2:
			//stops, extends solenoids, stays in this state for 3 seconds
			left.set(ControlMode.PercentOutput, 0);
			right.set(ControlMode.PercentOutput, 0);
			leftSole.set(true);
			rightSole.set(true);
			if(Time.getTime()-initTime >=3){
				//resets encoders as state 3 uses them
				left.setSelectedSensorPosition(0, 0, 0);
				right.setSelectedSensorPosition(0, 0, 0);
				state = 3;
			}
			break;
		case 3:
			//go until encoder counts are at 1000, backwards
			left.set(ControlMode.PercentOutput, -.5);
			right.set(ControlMode.PercentOutput, .5);
			if(right.getSelectedSensorPosition(0) >= 1000 && left.getSelectedSensorPosition(0) < -1000){
				state = 4;
			}
		break;
		case 4:
			//stays in this case when finished with the rest of the states
			left.set(ControlMode.PercentOutput, 0);
			right.set(ControlMode.PercentOutput, 0);
			//zeros motors, retracts left solenoid
			rightSole.set(false);
			break;
		}
	}
}
