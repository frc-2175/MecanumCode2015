
package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    RobotDrive mecanumDrive;
    OI oi;
    Jaguar frontLeft, rearLeft, frontRight, rearRight;
	
	
	public void robotInit() {
    	
		oi = new OI();
		
		frontLeft = new Jaguar(0);
    	rearLeft = new Jaguar(1);
    	frontRight = new Jaguar(2);
    	rearRight = new Jaguar(3);
		
		mecanumDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
		mecanumDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		mecanumDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        double magnitude = oi.getMagnitude();
        double direction = oi.getAngle();
        double turning = oi.getTurning();
        
        mecanumDrive.mecanumDrive_Polar(magnitude, direction, turning);
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
