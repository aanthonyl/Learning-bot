/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team86.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
private Drive Drive;
private States States;

	@Override
	public void robotInit() {
		IO.left.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		IO.right.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	Drive = new Drive(IO.left,IO.right);
	//as a subsystem we define it in robotInit
	States = new States(IO.leftSole, IO.rightSole, IO.left, IO.right);
	}

		@Override
	public void autonomousInit() {
	Drive.init();
	}


	@Override
	public void autonomousPeriodic() {
	Drive.auto();
	}

	@Override
	public void teleopInit(){
		//initialization of our subsystems
		//Drive.init();
		States.init();
	}
	
	@Override
	public void teleopPeriodic() {
		//turns on the compressor for pnuematics- the solenoids
		IO.compressorRelay.set(IO.compressor.enabled() ? Relay.Value.kForward : Relay.Value.kOff);
		//update for our subsystems
		//Drive.update();
		Time.update();
		States.states();
	}

	
	@Override
	public void testPeriodic() {
	}
}
