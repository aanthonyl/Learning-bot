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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
private Drive Drive;
	

	@Override
	public void robotInit() {
		IO.left.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		IO.right.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	Drive = new Drive(IO.left,IO.right);
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
		Drive.init();
	}
	
	@Override
	public void teleopPeriodic() {
		Drive.update();
	}

	
	@Override
	public void testPeriodic() {
	}
}
