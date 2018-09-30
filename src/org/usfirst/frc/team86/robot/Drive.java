package org.usfirst.frc.team86.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive {
	private TalonSRX left;
	private TalonSRX right;
	private int mode = 1;
	
public Drive (TalonSRX left, TalonSRX right){
	this.left = left;
	this.right = right;
}


public void auto(){
	switch(mode){
	
	case 1:
		SmartDashboard.putNumber("left encoder counts", left.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("right encoder counts", right.getSelectedSensorPosition(0));

	left.set(ControlMode.PercentOutput, .2);
	right.set(ControlMode.PercentOutput,- .2);	
	if(right.getSelectedSensorPosition(0) < -500 && left.getSelectedSensorPosition(0) > 500){
		left.set(ControlMode.PercentOutput, 0);
		right.set(ControlMode.PercentOutput, 0);
		left.setSelectedSensorPosition(0, 0, 0);
		right.setSelectedSensorPosition(0, 0, 0);
		mode = 2;
			}
		break;
	case 2:
		SmartDashboard.putNumber("left encoder counts", left.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("right encoder counts", right.getSelectedSensorPosition(0));

		left.set(ControlMode.PercentOutput, -.2);
		right.set(ControlMode.PercentOutput, .2);	
		if(right.getSelectedSensorPosition(0) > 300 && left.getSelectedSensorPosition(0)<-300){
			mode = 3;
		}
		break;
	case 3:
		SmartDashboard.putNumber("left encoder counts", left.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("right encoder counts", right.getSelectedSensorPosition(0));

		left.set(ControlMode.PercentOutput, 0);
		right.set(ControlMode.PercentOutput, 0);
		break;
	}
}


public void init(){
	left.set(ControlMode.PercentOutput, 0);
	right.set(ControlMode.PercentOutput, 0);
	left.setSelectedSensorPosition(0, 0, 0);
	right.setSelectedSensorPosition(0, 0, 0);
}

public void update(){
	left.set(ControlMode.PercentOutput, IO.leftStick.getY());
	right.set(ControlMode.PercentOutput, IO.rightStick.getY());
	
	SmartDashboard.putNumber("left encoder counts", left.getSelectedSensorPosition(0));
	SmartDashboard.putNumber("right encoder counts", right.getSelectedSensorPosition(0));
}







}
