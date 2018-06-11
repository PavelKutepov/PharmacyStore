package pkutepov.com.dao.address_dao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    Address addAdress(Address address);

    List<Address> getAllAddressList();

    void delAdress(Locality l, String street, String house, String apartament);

    Address getAddressForId(int addressId);
}
