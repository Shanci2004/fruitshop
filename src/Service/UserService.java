package Service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;

public class UserService {
    private UserDao uDao = new UserDao();
    public boolean register(User user){
        try {
            uDao.addUser(user);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User login(String account, String password){
        User user =  null;
        try {
            user = uDao.selectbyAccountPassword(account, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(user != null){
            return user;
        }
        return null;
    }


}
