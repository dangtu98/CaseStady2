package Model;

import Manager.ManagerUser;

public class Login {

    public Login() {
    }

    public boolean loginSystem(String acc , String password){
        ManagerUser user = new ManagerUser();
        for (int i = 0 ; i < user.getUsers().size(); i++){
            if (user.getUsers().get(i).getAccount().trim().equals(acc) &&
                    user.getUsers().get(i).getPassword().equals(password)){
                System.out.println("ĐĂNG NHẬP THÀNH CÔNG ");
                return true;
            }
        }
        return false;
    }

}
