package Manager;

import Interface.Manager;
import Model.Staff;
import Model.StaffFullTime;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStaffFull implements Manager {
    private ArrayList<StaffFullTime> staffFull;
    private final Scanner scanner = new Scanner(System.in);
    private File file = new File("src/IO/NVFullTime");


    public File getFile(){
        return file;
    }


    public void setStaffFull(ArrayList<StaffFullTime> staffFull){
       this.staffFull = staffFull;

    }

    public ManagerStaffFull() {
        if(file.length() == 0){
            this.staffFull = new ArrayList<>();
        }else {
            this.staffFull = readFromFile();
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
        if (staffFull.isEmpty()){
            System.out.println(" - HIỆN CHƯA CÓ NHÂN VIÊN FULL TIME NÀO !!");
        }
        for (StaffFullTime s : staffFull){
            System.out.println(s);
        }
    }

    @Override
    public void addStaff() {
        System.out.println("Nhập Mã Id: ");
        String idCheck = scanner.nextLine();
        if (validateId(idCheck)){
            int id = Integer.parseInt(idCheck);
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
            System.out.println("Nhập Lương CB: ");
            double salary = scanner.nextDouble();
            System.out.println("Nhập Thêm Giờ: ");
            double time = scanner.nextDouble();
            if (checkAge(age) && !getStatus(status).equals("")){
                staffFull.add(new StaffFullTime(id , type , name , age , address , getStatus(status),salary,time));
                writeToFile();
            }else {
                System.out.println("Lỗi Nhập Dữ liệu Tuổi!!!");
            }
            System.out.println("THÊM NHÂN VIÊN THÀNH CÔNG !");
        }


    }

    @Override
    public Staff deleteStaff(int id) {
        StaffFullTime fullTime = null;
        for (StaffFullTime s : staffFull){
            if (s.getId() == id){
                fullTime = s;
            }
        }
        int index = staffFull.indexOf(fullTime);
        fullTime = staffFull.remove(index);
        writeToFile();
        System.out.println("ĐÃ XÓA !!");
        return fullTime;
    }

    @Override
    public Staff editStaff(int id) {
       StaffFullTime fullTime = null;
       for (StaffFullTime s : staffFull){
           if (s.getId() == id){
               fullTime = s;
           }
       }
       if (fullTime != null){
           int index = staffFull.indexOf(fullTime);
           scanner.nextLine();
           System.out.println("Nhập Kiểu NV: ");
           fullTime.setType(scanner.nextLine());
           System.out.println("Nhập Tên NV: ");
           fullTime.setName(scanner.nextLine());
           System.out.println("Nhập Tuổi: ");
           int age = scanner.nextInt();
           fullTime.setAge(age);
           scanner.nextLine();
           System.out.println("Nhập Địa Chỉ: ");
           fullTime.setAddress(scanner.nextLine());
           System.out.println("Chọn Trạng Thái");
           System.out.println("1.ON");
           System.out.println("2.OFF");
           int status = scanner.nextInt();
           System.out.println("Nhập Lương CB: ");
           fullTime.setSalary(scanner.nextDouble());
           System.out.println("Nhập Thêm Giờ: ");
           fullTime.setOverTime(scanner.nextDouble());
           if (checkAge(age) && !getStatus(status).equals("")){
              fullTime.setStatus(getStatus(status));
              staffFull.set(index,fullTime);
              writeToFile();
           }else {
               System.out.println("Lỗi Nhập Dữ liệu Tuổi!!!");
           }
           System.out.println("ĐÃ SỬA THÀNH CÔNG !");
       }
       return fullTime;
    }

    public String changeStatusON(int id){
        String status1 = "";
        StaffFullTime staffFullTimeChange = null;
        for (StaffFullTime s : staffFull){
            if (s.getId() == id){
                staffFullTimeChange = s;
                staffFullTimeChange.setStatus("ON");
                writeToFile();
                status1 = s.getName() + " " + "ĐÃ HOẠT ĐỘNG";
            }
        }
        return status1;
    }

    public String changeStatusOFF(int id){
        String status= "";
        StaffFullTime staffFullTimeChange2 = null;
        for (StaffFullTime s : staffFull) {
            if (s.getId() == id) {
                staffFullTimeChange2 = s;
                staffFullTimeChange2.setStatus("OFF");
                writeToFile();
                status = s.getName() + " " + "ĐÃ TẠM NGHỈ";
            }
        }
        return status;
    }

    public ArrayList<StaffFullTime> searchStaffName(String name){
        ArrayList<StaffFullTime> fullTimes = new ArrayList<>();
        for (StaffFullTime s : staffFull){
            if (s.getName().equals(name)){
                fullTimes.add(s);
            }
        }
        return fullTimes;
    }

    public String PayRoll(int id){
        String pay = "";
        StaffFullTime stf = null;
        for (StaffFullTime s : staffFull){
            if (s.getId() == id){
                stf = s;
                pay = "LƯƠNG CỦA " + s.getName() + " LÀ: " + " " + stf.getPayRoll() + " $ " ;
            }
        }
        return pay;
    }

    public void writeToFile(){
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(staffFull);
            oss.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<StaffFullTime> readFromFile(){
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new java.io.ObjectInputStream(fis);
            staffFull = (ArrayList<StaffFullTime>)  ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return staffFull;
    }
    public boolean validateId(String id1){
        String regexID = "\\d";
        if (!id1.matches(regexID)){
            System.err.println("ID PHẢI LÀ SỐ ");
            return false;
        }
        return true;
    }



}
