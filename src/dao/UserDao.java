package dao;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utiils.DataSourceUtils;

import java.sql.SQLException;

public class UserDao {
    public void addUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user(userName,account,password,avatar,isadmin) values(?,?,?,?,?)";
        runner.update(sql,user.getUserName(),user.getAccount(),user.getPassword(),user.getAvatar(),user.isIsadmin());
    }

    public User selectbyAccountPassword(String account, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where account = ? and password = ?";
        return runner.query(sql, new BeanHandler<User>(User.class), account, password);
    }

}
