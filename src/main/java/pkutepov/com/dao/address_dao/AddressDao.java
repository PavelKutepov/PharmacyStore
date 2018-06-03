package pkutepov.com.dao.address_dao;

import java.util.List;

public interface AddressDao {

    void addAddress(String street, int house, int apartment, Locality locality);

    List<Address> getAllAddressList();

    void delAddress(Locality l, String street, String house, String apartament);

    Address getAddressForId(int addressId);
}
