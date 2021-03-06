package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.subsystems.*;
import frc.robot.utilities.F310Controller;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public JoystickButton brakeButton, debugButton;
    public F310Controller driveStick, manipulatorStick;

    public OI() {
        driveStick = new F310Controller(0);
        brakeButton = new JoystickButton(driveStick, 2);
        brakeButton.whileHeld(new Brakes());
        debugButton = new JoystickButton(driveStick, 3);
        debugButton.toggleWhenPressed(new DebugOutput());
        
        //manipulatorStick = new XboxController(1);
        manipulatorStick = new F310Controller(1);
    
        // SmartDashboard Buttons
        SmartDashboard.putData("DriveWithJoystick", new DriveWithJoystick());
        SmartDashboard.putData("Brakes", new Brakes());
        
        SmartDashboard.putData("ResetEncoders", new ResetEncoders());
        
        SmartDashboard.putData("DoNothing", new DoNothing());
        SmartDashboard.putData("DriveForward", new DriveForward());
        SmartDashboard.putData("DriveBackward", new DriveBackward());
        
        SmartDashboard.putData("SetLED", new SetLED());
    }

    public F310Controller getDriveStick() {
        return driveStick;
    }

    public F310Controller getManipulatorStick() {
        return manipulatorStick;
    }
}
