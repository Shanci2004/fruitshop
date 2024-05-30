package dao;

import jdk.nashorn.internal.ir.ReturnNode;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utiils.DataSourceUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //注册业务
    public void addUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user(userName,account,password,avatar,isadmin) values(?,?,?,?,?)";
        runner.update(sql,user.getUserName(),user.getAccount(),user.getPassword(),user.getAvatar(),user.isIsadmin());
    }

    public boolean isUserNameExist(String userName) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where userName = ?";
        User u = runner.query(sql, new BeanHandler<User>(User.class), userName);
        if(u == null){
            return false;
        }else{
            return true;
        }
    }


    public  boolean isAccountExist(String account) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where account = ?";
        User u = runner.query(sql, new BeanHandler<User>(User.class), account);
        if(u == null){
            return false;
        }else{
            return true;
        }
    }
    //登录业务
    public User selectbyAccountPassword(String account, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where account = ? and password = ?";
        return runner.query(sql, new BeanHandler<User>(User.class), account, password);
    }

    public User selectbyuserNamePassword(String userName, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where userName = ? and password = ?";
        return runner.query(sql, new BeanHandler<User>(User.class), userName, password);
    }
    //更改密码
    public void updatePassword(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set password = ? where userId = ?";
        runner.update(sql, user.getPassword(), user.getId());
    }
    //更改信息
    public void updateInfo(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set avatar = ?, userName = ?, phone = ? where userId = ?";
        runner.update(sql, user.getAvatar(), user.getUserName(), user.getPhone(), user.getId());
    }
}
