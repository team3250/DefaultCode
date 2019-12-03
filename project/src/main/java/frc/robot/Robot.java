package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

  Joystick joyStick; //this is a joystick

  Drive thinkpad;

  PID pid;

  DoubleSolenoid puncher;

  DoubleSolenoid.Value puncherValue = DoubleSolenoid.Value.kReverse;

  @Override
  public void robotInit() {
    joyStick=new Joystick(0); // boomer
      //drew's deadly rubber bands
      //lol u big gey
    thinkpad = new Drive();

    pid = new PID(0.025, 0.0003);
    pid.setSetpoint(30);

    puncher = new DoubleSolenoid(4, 0);
  }

  @Override
  public void robotPeriodic() {
      SmartDashboard.putNumber("encoderLeft", thinkpad.getLeftEncoder());
      SmartDashboard.putNumber("encoderRight", thinkpad.getRightEncoder());
  }

  @Override
  public void autonomousInit() {
    thinkpad.resetEnc();
  }

  @Override
  public void autonomousPeriodic() {
    double avgEncoder = (thinkpad.getLeftEncoder()+thinkpad.getRightEncoder())/2;
    double output = pid.run(avgEncoder);
    SmartDashboard.putNumber("Derror", pid.getDerror());
    thinkpad.set(output, output);
  }

   @Override
   public void teleopInit() {
      thinkpad.resetEnc();
      if(puncherValue == DoubleSolenoid.Value.kReverse){
          puncherValue = DoubleSolenoid.Value.kForward;
      }else{
          puncherValue = DoubleSolenoid.Value.kReverse;
      }
    }

    @Override
  public void teleopPeriodic() {
      double joyY = -joyStick.getY();
      double joyx = joyStick.getX();

//      thinkpad.set((joyY+joyx)/4, (joyY-joyx)/4);

      puncher.set(puncherValue);
  }

  @Override
  public void testPeriodic() {

  }
}
