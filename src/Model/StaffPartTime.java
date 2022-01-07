package Model;

import java.io.Serializable;

public class StaffPartTime extends Staff implements Serializable {
    private double TimeWork;

    public StaffPartTime(double timeWork) {
        TimeWork = timeWork;
    }

    public StaffPartTime(int id, String type, String name, int age, String address, String status, double timeWork) {
        super(id, type, name, age, address, status);
        TimeWork = timeWork;
    }

    public double getTimeWork() {
        return TimeWork;
    }

    public void setTimeWork(double timeWork) {
        TimeWork = timeWork;
    }

    public double  getPayRollPartTime(){
        return this.TimeWork * 10;
    }

    @Override
    public String toString() {
        return "StaffPartTime : " + super.toString() +
                "TimeWork : " + TimeWork
                ;
    }
}
