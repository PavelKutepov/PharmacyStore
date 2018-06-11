package pkutepov.com.dao.address_dao;

import java.util.List;

public interface AddressDao {

    Address addAddress(Address address);

    List<Address> getAllAddressList();

    void delAddress(Locality l, String street, String house, String apartament);

    Address getAddressForId(int addressId);
}
