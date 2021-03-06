package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	Joystick moveJoystick;
	Joystick rotateJoystick;
	double deadbandValue = 0.1;
	
	public OI() {
		moveJoystick = new Joystick(0);
		rotateJoystick = new Joystick(1);
	}
	
	public double handleDeadband(double input) {
		if (Math.abs(input) <= deadbandValue) {
			return 0;
		} else {
			return (input/(1-deadbandValue));
		}
	}
	
	public double getMagnitude() {
		double xPos = handleDeadband(moveJoystick.getX());
		double yPos = handleDeadband(moveJoystick.getY());
		
		double magnitude = Math.sqrt(Math.pow(xPos,2)+Math.pow(yPos, 2));
		
		return magnitude;
		
	}
	
	public double getAngle() {
		double xPos = handleDeadband(moveJoystick.getX());
		double yPos = handleDeadband(moveJoystick.getY());
		
		double angleInRad = Math.atan2(xPos, -yPos);
		double angleInDeg = Math.toDegrees(angleInRad);
		
		return angleInDeg;
		
	}
	
	public double getTurning() {
		return handleDeadband(rotateJoystick.getX());
	}
}
