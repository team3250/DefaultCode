package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Constants {

    public static boolean isCompBot = true;

    public static class Drive {
		public static int MLeftNum = 11, MRightNum = 14;
		public static int[] slaveNums = {10,12, 13,15}; //left to right
		public static TalonSRX rightEncoder = new TalonSRX(41);
        public static TalonSRX leftEncoder = new TalonSRX(22); //was 22
		public static double wheelDiameter = 5.5, // inches
				wheelCircumference = wheelDiameter * Math.PI, // inches
                robotDiameter = 29; // inches (for estimating angle without a gyro)
        
        public static int[] leftDriveMotors = {10, 11, 12};
        public static int[] rightDriveMotors = {13, 14, 15};
        
        public static SpeedControllerGroup leftDrive = new SpeedControllerGroup(new CANSparkMax(leftDriveMotors[0], MotorType.kBrushless), new CANSparkMax(leftDriveMotors[1], MotorType.kBrushless), new CANSparkMax(leftDriveMotors[2], MotorType.kBrushless));
		public static SpeedControllerGroup rightDrive = new SpeedControllerGroup(new CANSparkMax(rightDriveMotors[0], MotorType.kBrushless), new CANSparkMax(rightDriveMotors[1], MotorType.kBrushless), new CANSparkMax(rightDriveMotors[2], MotorType.kBrushless));
    }

    public static class Arm {
        public static double[] armCenterGrav = {10.4804, 0.0682};

        public static double weight = 5.2;
        public static double armGearRatio = 400;
        public static double offset = 786;

        public static double maxAngle = 924;

        public static double motorStallTorque = 6.28; // Stall Torque For 775 Pro
        public static double armMotorNum = 2;

    }

    public static class Telescope {
        public static double telescopeWeight = 3.57;

        public static double centerIn = 6.5517;
        public static double centerOut = 18.9897;

        public static boolean fullExtend = false;

        public static int fullExtendEncoder =7890;
        public static int fullRetractEncoder = 104;
        public static double range = Math.abs(fullRetractEncoder - fullExtendEncoder);
    
        public static double extendedDist = 12.438;
        public static double encoderToInch = extendedDist/range;
        
        public static double fullRetractDistance = 24.2629;
        public static double fullExtendDistance = 36.7009;
    }

    public static class Wrist {
        public static double wristWeight = 6.85;

        public static double wristGearRatio = 380;

        public static double[] wristCenterGravity = {6.4594, 0.7232};

        public static int[] pistonNums = {5,2};
		public static Value on = Value.kForward,
				off = Value.kReverse;

    }

    public static class GroundGripper{
        public static int pivotNum = 50;
        public static int rollersNum = 51;
        public static int resetNum = 8;
        public static TalonSRX pivotEncoder = new TalonSRX(22);

        //NOT ARM GRIPPER
        public static double encAt10 = 10781;
        //NOT ARM GRIPPER
        public static double encAt90 = 5280;
        //NOT ARM GRIPPER

        public static double comOffsetAngle = -0.50483;
    }

    public static class Climber{
        public static int climbNum = 30;
        public static int footNum = 31;

        public static double topVal = 0;
        public static double bottomVal = 308677;

        public static double topLen = 0;
        public static double bottomLen = 1;

        public static int[] guideNums = {7, 3}; //7 is down
        public static Value down = Value.kForward;
        public static Value up = Value.kReverse;
    }

    public static class Image{
        public static int imageWidth = 320;
        public static int imageHeight = 240;
    }
}
