package test_dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkutepov.com.dao.address_dao.Address;
import pkutepov.com.dao.address_dao.AddressService;
import pkutepov.com.dao.address_dao.LocalityDao;


import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/testApplicationContext.xml")
public class TestAddressDao {

    @Autowired
    AddressService addressService;
    @Autowired
    LocalityDao localityDao;

    @Test
    public void addAddressTest(){
   System.out.println("addAddressTest");
//        Locality locality = new Locality("Moсква","Московская Область","Москва");
//        localityDao.addLocality(locality);

//    addressService.addAdress("Снежная",24,3,locality);
    }
    @Test
    public void getddressTest(){
        System.out.println("getAddressTest");


        List<Address> addresses=  addressService.getAllAddressList();
        assertNotNull(addresses);
        Address address=  addressService.getAddressForId(3);
}
}
