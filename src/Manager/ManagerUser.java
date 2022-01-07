package Manager;
import Model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerUser {
    private ArrayList<User> users;
    private Scanner scanner = new Scanner(System.in);
    private File fileAccount = new File("src/IO/usertext");


    public ArrayList<User> getUsers() {
        return users;
    }

    public File getFile(){
        return fileAccount;
    }

    public ManagerUser() {
        if (fileAccount.length() == 0) {
            this.users = new ArrayList<>();
        }else {
            this.users = readFromFile();
        }
    }

    public void addStaff(){
        System.out.println("Nhập Account :");
        String account = scanner.nextLine();
        System.out.println("Nhập PassWord: ");
        String passWord = scanner.nextLine();
        users.add(new User(account,passWord));
        writeToFile();
    }

    public User editUser(String account){
        User user = null;
        for (User us : users){
            if (us.getAccount().equals(account)){
                user = us;
            }
        }
        if (user != null){
            int index = users.indexOf(user);
            System.out.println("Account Mới: ");
            String acc = scanner.nextLine();
            user.setAccount(acc);
            System.out.println("PassWord Mới: ");
            String pw = scanner.nextLine();
            user.setPassword(pw);
            users.set(index,user);
            writeToFile();
        }
        return user;
    }

    public User deleteUser(String account){
        User user = null;
        for (User use : users){
            if (use.getAccount().equals(account)){
                user = use;
            }
        }
        int index = users.indexOf(user);
        user = users.remove(index);
        writeToFile();
        return user;
    }

    public void displayUser(){
        for (User us : users){
            System.out.println(us);
        }
    }

    public void writeToFile(){
        try{
            FileOutputStream fos = new FileOutputStream(fileAccount);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(users);
            oss.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<User> readFromFile(){
        try{
            FileInputStream fis = new FileInputStream(fileAccount);
            ObjectInputStream ois = new java.io.ObjectInputStream(fis);
            users = (ArrayList<User>)  ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
}
