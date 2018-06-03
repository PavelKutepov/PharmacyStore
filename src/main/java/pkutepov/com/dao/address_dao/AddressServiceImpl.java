package pkutepov.com.dao.address_dao;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    private AddressDao addressDao;
    private LocalityDao localityDao;


    @Override
    public void addAdress(String street, int house, int apartment, Locality locality) {
        addressDao.addAddress(street, house, apartment, locality);
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

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setLocalityDao(LocalityDao localityDao) {
        this.localityDao = localityDao;
    }

    public LocalityDao getLocalityDao() {
        return localityDao;
    }
}
