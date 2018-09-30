package org.usfirst.frc.team86.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

public class IO {
	public static TalonSRX right = new TalonSRX(56);
	public static TalonSRX left = new TalonSRX(57);
	
	public static Joystick leftStick = new Joystick(0);
	public static Joystick rightStick = new Joystick(1);

}
