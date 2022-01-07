package Model;

import java.io.Serializable;

public class StaffFullTime extends Staff implements Serializable {
    private double salary;
    private double OverTime;


    public StaffFullTime(int id, String type, String name, int age, String address, String status) {
    }

    public StaffFullTime(int id, String type, String name, int age, String address, String status, double salary, double overTime) {
        super(id, type, name, age, address, status);
        this.salary = salary;
        this.OverTime = overTime;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getOverTime() {
        return OverTime;
    }

    public void setOverTime(double overTime) {
        this.OverTime = overTime;
    }

    public double getPayRoll(){
        return this.salary + (this.OverTime * 2);
    }

    @Override
    public String toString() {
        return (String.format("%-5d%-20s%-10s%-10d%-15s%-15s%-20.2f%-20.2f\n"
                ,getId(),getType(),getName(),getAge(),getAddress(),getStatus(),getSalary(),getOverTime()));
    }
}
