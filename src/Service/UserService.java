package Service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.List;

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
    //修改密码
    public void changePwd(User user){
        try {
            uDao.updatePassword(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //修改信息
    public void changeInfo(User user){
        try {
            uDao.updateInfo(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //获取用户列表
    public List<User> getUserList(){
        try {
            return uDao.selectUserList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //获取用户
    public User getUserById(int userId){
        try {
            return uDao.selectUserById(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //删除用户
    public boolean removeUser(int userId){
        try {
            if(uDao.deleteUserById(userId)){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
