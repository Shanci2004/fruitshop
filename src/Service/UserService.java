package Service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;

public class UserService {
    private UserDao uDao = new UserDao();
    //注册
    public boolean register(User user){
        try {
            if(uDao.isUserNameExist(user.getUserName())){
                return false;
            }
            if(uDao.isAccountExist(user.getAccount())){
                return false;
            }
            uDao.addUser(user);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //登录
    public User login(String ua, String password){
        User user =  null;
        try {
            user = uDao.selectbyAccountPassword(ua, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(user != null){
            return user;
        }
        try {
            user = uDao.selectbyuserNamePassword(ua, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(user != null){
            return user;
        }
        return null;
    }


}
