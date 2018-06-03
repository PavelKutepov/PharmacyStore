package pkutepov.com.dao.address_dao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    void addAdress(String street, int house, int apartment, Locality locality);

    List<Address> getAllAddressList();

    void delAdress(Locality l, String street, String house, String apartament);

    Address getAddressForId(int addressId);
}
