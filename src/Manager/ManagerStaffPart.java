package Manager;

import Interface.Manager;
import Model.Staff;
import Model.StaffFullTime;
import Model.StaffPartTime;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStaffPart implements Manager {
    private ArrayList<StaffPartTime> staffPart;
    private final Scanner scanner = new Scanner(System.in);
    private File file2 = new File("src/IO/NVPartTime.txt");

    public File getFile(){
        return file2;
    }


    public ManagerStaffPart() {
        if (file2.length() == 0){
            this.staffPart = new ArrayList<>();
        }else {
            this.staffPart = readFromFile();
        }

    }

    public boolean checkAge(int age){
        return (age >=18 && age <=60);
    }

    public String getStatus(int choice){
        String status ="";
        switch (choice){
            case 1:
                status ="ON";
                break;
            case 2:
                status="OFF";
                break;
        }
        return status;
    }

    @Override
    public void displayAllStaff() {
        if (staffPart.isEmpty()){
            System.out.println(" - HIỆN CHƯA CÓ NHÂN VIÊN PART TIME NÀO !!");
        }
        for (StaffPartTime s : staffPart){
            System.out.println(s);
        }
    }

    @Override
    public void addStaff() {
        System.out.println("Nhập Mã Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập Kiểu NV: ");
        String type = scanner.nextLine();
        System.out.println("Nhập Tên NV: ");
        String name = scanner.nextLine();
        System.out.println("Nhập Tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập Địa Chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Chọn Trạng Thái");
        System.out.println("1.ON");
        System.out.println("2.OFF");
        int status = scanner.nextInt();
        System.out.println("Nhập Giờ làm: ");
        double time = scanner.nextDouble();
        if (checkAge(age) && !getStatus(status).equals("")){
            staffPart.add(new StaffPartTime(id , type , name , age , address , getStatus(status),time));
            writeToFile();
        }else {
            System.out.println("Lỗi Nhập Dữ liệu Tuổi!!!");
        }
    }

    @Override
    public Staff deleteStaff(int id) {
        StaffPartTime partTime = null;
        for (StaffPartTime s : staffPart){
            if (s.getId() == id){
                partTime = s;
            }
        }
        int index = staffPart.indexOf(partTime);
        partTime = staffPart.remove(index);
        writeToFile();
        return partTime;
    }

    @Override
    public Staff editStaff(int id) {
        StaffPartTime partTime = null;
        for (StaffPartTime s : staffPart){
            if (s.getId() == id){
                partTime = s;
            }
        }
        if (partTime != null){
            int index = staffPart.indexOf(partTime);
            System.out.println("Mã Id Mới: ");
            int id1 = scanner.nextInt();
            partTime.setId(id1);
            scanner.nextLine();
            System.out.println("Nhập Kiểu NV: ");
            String type = scanner.nextLine();
            partTime.setType(type);
            System.out.println("Nhập Tên NV: ");
            String name = scanner.nextLine();
            partTime.setName(name);
            System.out.println("Nhập Tuổi: ");
            int age = scanner.nextInt();
            partTime.setAge(age);
            scanner.nextLine();
            System.out.println("Nhập Địa Chỉ: ");
            String address = scanner.nextLine();
            partTime.setAddress(address);
            System.out.println("Chọn Trạng Thái");
            System.out.println("1.ON");
            System.out.println("2.OFF");
            int status = scanner.nextInt();
            System.out.println("Nhập Giờ Làm: ");
            double time = scanner.nextDouble();
            partTime.setTimeWork(time);
            if (checkAge(age) && !getStatus(status).equals("")){
                partTime.setStatus(getStatus(status));
                staffPart.set(index,partTime);
                writeToFile();
            }else {
                System.out.println("Lỗi Nhập Dữ liệu Tuổi!!!");
            }
        }
        return partTime;
    }

    public ArrayList<StaffPartTime> searchStaffName(String name){
        ArrayList<StaffPartTime> partTimes = new ArrayList<>();
        for (StaffPartTime s : staffPart){
            if (s.getName().equals(name)){
                partTimes.add(s);
            }
        }
        return partTimes;
    }
    public Staff RollPartTime(int id){
        StaffPartTime stf = null;
        for (StaffPartTime s : staffPart){
            if (s.getId() == id){
                stf = s;
                System.out.println("Lương của Nhân Viên " + stf.getName() + " là " + stf.getPayRollPartTime() + " $ " );
            }
        }
        return stf;
    }

    public void writeToFile(){
        try{
            FileOutputStream fos =new FileOutputStream(file2);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(staffPart);
            oss.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<StaffPartTime> readFromFile(){
        try{
            FileInputStream fis = new FileInputStream(file2);
            ObjectInputStream ois = new java.io.ObjectInputStream(fis);
            staffPart = (ArrayList<StaffPartTime>) ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return staffPart;
    }
}
