package Main;

import Manager.ManagerStaffFull;
import Manager.ManagerStaffPart;
import Model.Staff;
import Model.StaffFullTime;
import Model.StaffPartTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MainView {
  private   ManagerStaffFull managerStaffFull = new ManagerStaffFull();
  private   ManagerStaffPart managerStaffPart = new ManagerStaffPart();
  private   MainLogin mainLogin = new MainLogin();

    public  void runMain() {
        mainViewRun(managerStaffFull, managerStaffPart);
    }

    private void mainViewRun(ManagerStaffFull managerStaffFull, ManagerStaffPart managerStaffPart) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("**     QUẢN LÝ NHÂN VIÊN QUÁN HÁT      **");
            System.out.println("*                                       *");
            System.out.println("*         1.Nhân viên FullTime          *");
            System.out.println("*         2.Nhân viên PartTime          *");
            System.out.println("*         3.Hiện toàn Bộ Nhân Viên      *");
            System.out.println("*         4.Đăng Xuất                   *");
            System.out.println("*                                       *");
            System.out.println("*******                             *****");
            System.out.println("BẠN CHỌN QUẢN LÝ NHÂN VIÊN NÀO: ");
            try{
                choice = Integer.parseInt(scanner.nextLine());
                while (choice < 1 || choice > 4){
                    System.out.println("Chỉ Được Nhập Từ 1 Đến 3");
                    choice = scanner.nextInt();
                }
            }catch (Exception e){
                System.err.println("Bạn Chỉ Được Nhập Số ");
                mainViewRun(managerStaffFull,managerStaffPart);
            }
            switch (choice){
                case 1:
                   int choice1;
                   do{
                       System.out.println("----------NHÂN VIÊN FULLTIME---------");
                       System.out.println("1.Thêm Nhân viên");
                       System.out.println("2.Xem Nhân Viên");
                       System.out.println("3.Sửa Thông Tin");
                       System.out.println("4.Xóa Nhân viên");
                       System.out.println("5 Tìm Tên Nhân viên");
                       System.out.println("6.Bật Trạng Thái Làm: ");
                       System.out.println("7.Bật Trạng Thái Nghỉ:");
                       System.out.println("8.Tính Lương Nhân Viên 1h/2$ :");
                       System.out.println("0.Exit");
                       System.out.println("Chọn Thông Tin: ");
                       choice1 = scanner.nextInt();
                       scanner.nextLine();
                       switch (choice1){
                           case 1:
                               managerStaffFull.addStaff();
                               break;
                           case 2:
                               System.out.printf("%-5S%-20S%-10S%-10S%-15S%-15S%-20S%-20S\n"
                                       ,"ID","CÔNG VIỆC","TÊN","TUỔI","ĐỊA CHỈ","TRẠNG THÁI","LƯƠNG CỨNG","GIỜ THÊM");
                               managerStaffFull.displayAllStaff();
                               break;
                           case 3:
                               System.out.println("Mã ID Muốn Sửa : ");
                               int id1 = scanner.nextInt();
                               Staff s = managerStaffFull.editStaff(id1);
                               if (s == null){
                                   System.err.println("ID KHÔNG TỒN TẠI");
                               }else {
                                   System.out.println(s);
                               }
                               break;
                           case 4:
                               System.out.println("Nhập MÃ ID: ");
                               int id2 = scanner.nextInt();
                               Staff c = managerStaffFull.deleteStaff(id2);
                               if (c == null){
                                   System.err.println("ID KHÔNG TỒN TẠI");
                               }else {
                                   System.out.println(c);
                               }
                               break;
                           case 5:
                               scanner.nextLine();
                               System.out.println("Nhập vào Tên NV: ");
                               String name = scanner.nextLine();
                               ArrayList<StaffFullTime> h = managerStaffFull.searchStaffName(name);
                               System.out.println(h);
                               break;
                           case 6:
                               System.out.println("Nhập ID:");
                               int check = scanner.nextInt();
                               String s2 = managerStaffFull.changeStatusON(check);
                               if (s2 == null){
                                   System.out.println("ID KHÔNG TỒN TẠI");
                               }else {
                                   System.out.println(s2);
                               }
                               break;
                           case 7:
                               System.out.println("Nhập ID");
                               int check2 = scanner.nextInt();
                               String s1 = managerStaffFull.changeStatusOFF(check2);
                               if (s1 == null){
                                   System.err.println("ID KHÔNG TỒN TẠI");
                               }else {
                                   System.out.println(s1);
                               }
                               break;
                           case 8:
                               System.out.println("Nhập Vào ID");
                               int check3 = scanner.nextInt();
                               Staff Id =  managerStaffFull.PayRoll(check3);
                               if (Id == null){
                                   System.err.println("ID KHÔNG TỒN TẠI");
                               }else {
                                   System.out.println(Id);
                               }
                               break;
                       }
                   }while (choice1 != 0);
                   break;
                case 2:
                    int choice2;
                    do{
                        System.out.println("----------NHÂN VIÊN PARTTIME---------");
                        System.out.println("1.Thêm Nhân viên");
                        System.out.println("2.Xem Nhân Viên");
                        System.out.println("3.Sửa Thông Tin");
                        System.out.println("4.Xóa Nhân viên");
                        System.out.println("5 Tìm Tên Nhân viên");
                        System.out.println("6.Tính Lương Nhân Viên:");
                        System.out.println("0.Exit");
                        System.out.print("Chọn Thông Tin: ");
                        choice2 = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice2){
                            case 1:
                                managerStaffPart.addStaff();
                                break;
                            case 2:
                                managerStaffPart.displayAllStaff();
                                break;
                            case 3:
                                System.out.println("Mã ID Muốn Sửa : ");
                                int id1 = scanner.nextInt();
                                Staff s = managerStaffPart.editStaff(id1);
                                if (s == null){
                                    System.err.println("ID KHÔNG TỒN TẠI");
                                }else {
                                    System.out.println(s);
                                }
                                break;
                            case 4:
                                System.out.println("Nhập Mã ID: ");
                                int id2 = scanner.nextInt();
                                Staff c = managerStaffPart.deleteStaff(id2);
                                if (c == null){
                                    System.err.println("ID KHÔNG TỒN TẠI");
                                }else {
                                    System.out.println(c);
                                }
                                break;
                            case 5:
                                scanner.nextLine();
                                System.out.println("Nhập vào Tên NV: ");
                                String name = scanner.nextLine();
                                ArrayList<StaffPartTime> h = managerStaffPart.searchStaffName(name);
                                System.out.println(h);
                                break;
                            case 6:
                                System.out.println("Nhập Mã ID");
                                int check3 = scanner.nextInt();
                                Staff Id =  managerStaffPart.RollPartTime(check3);
                                if (Id == null){
                                    System.err.println("ID KHÔNG TỒN TẠI");
                                }else {
                                    System.out.println(Id);
                                }
                                break;
                        }
                    }while (choice2 !=0);
                    break;
                case 3:
                    System.out.println();
                    managerStaffFull.displayAllStaff();
                    System.out.println();
                    managerStaffPart.displayAllStaff();
                    System.out.println();
                    break;
                case 4:
                    mainLogin.mainByUser();
                    break;
            }
        }while (choice != 0);
    }
}
