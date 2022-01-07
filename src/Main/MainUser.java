package Main;

import Manager.ManagerUser;
import Model.User;

import java.util.Scanner;

public class MainUser {
    public static void main(String[] args) {
        ManagerUser managerUser = new ManagerUser();
        mainUserRun(managerUser);

    }

    private static void mainUserRun(ManagerUser managerUser) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("Chọn yêu cầu: ");
            System.out.println("1.Thêm User");
            System.out.println("2.Sửa User");
            System.out.println("3.Xóa User");
            System.out.println("4.Hiện Thị User");
            try{
                choice = Integer.parseInt(scanner.nextLine());
                while (choice < 1 || choice > 4){
                    System.out.println("Chỉ được Nhập từ 1 đến 4:");
                    choice = scanner.nextInt();
                }
            }catch (Exception e){
                System.err.println("Bạn Chỉ Được Nhập Số ");
                mainUserRun(managerUser);
            }
            switch (choice){
                case 1:
                    managerUser.addStaff();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Nhập Accont muốn sửa: ");
                    String acc = scanner.nextLine();
                    User us = managerUser.editUser(acc);
                    System.out.println(us);
                    break;
                case 3:
                    System.out.println("Nhập Accont muốn xóa: ");
                    String acc1 = scanner.nextLine();
                    User us1 = managerUser.deleteUser(acc1);
                    System.out.println(us1);
                    break;
                case 4:
                    managerUser.displayUser();
                    break;
            }
        }while (choice !=0);
    }
}
