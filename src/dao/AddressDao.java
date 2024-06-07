package dao;

import model.Address;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utiils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class AddressDao {
    //获取地址
    public List<Address> selectAddressbyUserId(int userId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from address where userId = ?";
        return runner.query(sql, new BeanListHandler<Address>(Address.class), userId);
    }
    public Address selectAddressByAddressId(int addressId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from address where addressId = ?";
        return runner.query(sql, new BeanHandler<Address>(Address.class), addressId);
    }
    //添加地址
    public void addAddress(Address address) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into address(addressId, userId, name, phone, region, area, label) values(?,?,?,?,?,?,?)";
        runner.update(sql, address.getAddressId(), address.getUserId(), address.getName(), address.getPhone(), address.getRegion(), address.getArea(), address.getLabel());
    }
    //修改地址
    public void updateAddress(Address address) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update address set name = ?, phone = ?, region = ?, area = ?, label = ? where addressId =? and userId =?";
        runner.update(sql, address.getName(), address.getPhone(), address.getRegion(), address.getArea(), address.getLabel(), address.getAddressId(), address.getUserId());
    }
    //删除地址
    public void deleteAddress(int addressId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from address where addressId = ?";
        runner.update(sql, addressId);
    }
}

