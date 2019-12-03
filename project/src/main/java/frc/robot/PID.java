package frc.robot;

public class PID {
    private double kp, kd;
    private double setpoint;
    private double error, derror, perror;

    public PID(double kp, double kd){
        this.kd = kd;
        this.kp = kp;
    }
    public double run(double sensor){
        error = setpoint - sensor;
        if(Double.isNaN(perror)){
            derror = 0;
        }else {
            derror = (error - perror)/0.005;
        }
        perror = error;
        double output = kp*error + kd*derror;
        return  output;
    }
    public void setSetpoint(double setpoint){
        this.setpoint = setpoint;
    }
    public double getError(){
        return error;
    }
    public  double getDerror(){
        return derror;
    }
}
