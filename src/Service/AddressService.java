package Service;

import dao.AddressDao;
import model.Address;

import java.sql.SQLException;
import java.util.List;

public class AddressService {
    private AddressDao addressDao = new AddressDao();

    public List<Address> getAddressListByUserId(int UserId){
        try {
            return addressDao.selectAddressbyUserId(UserId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Address getAddressByAddressId(int addressId){
        try {
            return addressDao.selectAddressByAddressId(addressId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAddress(Address address){
        try {
            addressDao.addAddress(address);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeAddress(Address address){
        try {
            addressDao.updateAddress(address);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAddress(int addressId){
        try {
            addressDao.deleteAddress(addressId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
