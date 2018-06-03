package test_dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkutepov.com.dao.medicine_dao.Medicine;
import pkutepov.com.dao.medicine_dao.MedicineService;


import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/testApplicationContext.xml")
public class TestMedicineDao {
    @Autowired
   private MedicineService medicineService;


    @Test
    public void medicineServiceTest(){
        System.out.println("medicineServiceTest");
        List<Medicine> medicines = medicineService.getAllMedicine();
        assertNotNull(medicines);
        Medicine medicine = medicineService.getMedecineById(1);
        assertNotNull(medicine);
    }


}
