package Main;

import Model.Login;
import java.util.Scanner;

public class MainLogin {

    public void mainByUser() {
        Login login = new Login();
        MainView mainView = new MainView();
        Scanner scanner = new Scanner(System.in);
        System.out.println("ĐĂNG NHẬP VÀO HỆ THỐNG ");
        System.out.println();
        System.out.println("ACCOUNT: ");
        String acc = scanner.nextLine();
        System.out.println("PASSWORD: ");
        String pw = scanner.nextLine();
        if (login.loginSystem(acc , pw)){
            System.out.println();
            System.out.println();
            mainView.runMain();
        }else {
            System.err.println("ĐĂNG NHẬP THẤT BẠI!!");
        }
    }
}
