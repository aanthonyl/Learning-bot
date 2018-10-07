package org.usfirst.frc.team86.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

public class IO {
	public static TalonSRX right = new TalonSRX(56);
	public static TalonSRX left = new TalonSRX(57);
	
	public static Joystick leftStick = new Joystick(0);
	public static Joystick rightStick = new Joystick(1);
	
	public static Compressor compressor = new Compressor(1);
	public static Relay compressorRelay = new Relay(0);

	public static Solenoid leftSole = new Solenoid(0);
	public static Solenoid rightSole = new Solenoid(1);
}
