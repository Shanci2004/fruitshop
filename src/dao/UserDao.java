package dao;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import utiils.DataSourceUtils;

import java.sql.SQLException;

public class UserDao {
    public void addUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user(userName,account,password,avatar,isadmin) values(?,?,?,?,?)";
        runner.update(sql,user.getUserName(),user.getAccount(),user.getPassword(),user.getAvatar(),user.isIsadmin());
    }
}
