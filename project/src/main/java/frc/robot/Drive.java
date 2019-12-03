package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class Drive {
    CANSparkMax right1, right2, left1, left2;
    TalonSRX encoderLeft, encoderRight;
    public Drive(){
        right1 = new CANSparkMax(10, CANSparkMaxLowLevel.MotorType.kBrushless);
        right2 = new CANSparkMax(11, CANSparkMaxLowLevel.MotorType.kBrushless);
        right1.setInverted(true);
        right2.setInverted(true);
        left1 = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
        left2 = new CANSparkMax(13, CANSparkMaxLowLevel.MotorType.kBrushless);
        encoderLeft = new TalonSRX(22);
        encoderRight = new TalonSRX(50);
    }
    public void set(double left, double right){
        right1.set(right);
        right2.set(right);
        left1.set(left);
        left2.set(left);
    }
    public double getLeftEncoder() {
        return (-encoderLeft.getSelectedSensorPosition()/4096.0)*(5.25*Math.PI);
    }
    public double getRightEncoder() {
        return (encoderRight.getSelectedSensorPosition()/4096.0)*(5.25*Math.PI);
    }

    public void resetEnc(){
        encoderRight.setSelectedSensorPosition(0);
        encoderLeft.setSelectedSensorPosition(0);
    }
}
