package pkutepov.com.dao.address_dao;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    private AddressDao addressDao;
    private LocalityDao localityDao;


    @Override
    public Address addAdress(Address address) {
        localityDao.addLocality(address.getLocality());

        return addressDao.addAddress(address);
    }

    @Override
    public List<Address> getAllAddressList() {
        return addressDao.getAllAddressList();
    }

    @Override
    public void delAdress(Locality l, String street, String house, String apartament) {

    }

    @Override
    public Address getAddressForId(int addressId) {
        return addressDao.getAddressForId(addressId);
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public LocalityDao getLocalityDao() {
        return localityDao;
    }

    public void setLocalityDao(LocalityDao localityDao) {
        this.localityDao = localityDao;
    }
}
