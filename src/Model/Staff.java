package Model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int id;
    private String type, name, address, status;
    private int age;

    public Staff() {
    }

    public Staff(int id, String type, String name, int age, String address, String status) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
        this.address = address;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "ID: " + id +
                " ,WORK: " + type +
                " ,NAME: " + name +
                " ,AGE: " +  age +
                " ,ADDRESS: " + address +
                " ,STATUS: " + status
                ;
    }
}
