package test_dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkutepov.com.dao.employer_dao.Departament;
import pkutepov.com.dao.employer_dao.DepartamentDao;
import pkutepov.com.dao.employer_dao.Employee;
import pkutepov.com.dao.employer_dao.EmployeeService;
import pkutepov.com.dao.user_dao.UserService;


import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/WEB-INF/testApplicationContext.xml ")
public class TestEmployeeDao {
    @Autowired
     private EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @Autowired
    DepartamentDao departamentDao;

    @Test
    public void employeeDaoTest(){
        System.out.println("employeeDaoTest");
   //  User user= userService.getUserById(1);
   //  Departament departament=   new Departament(1,"dfs","sdfsdf");
       // employeeService.addEmployee(user,departament);
     Employee employee= employeeService.getEmployeeById(1);
        assertNotNull(employee);
    }
    @Test
    public void departamentDaoTest(){
        System.out.println("departamentDaoTest");
        //departamentDao.addDepartament("deb","sdf");
       List<Departament> allDepartaments= departamentDao.getAllDepartament();
        assertNotNull(allDepartaments);
    Departament departament = departamentDao.getDepartamentById(1);

        assertNotNull(departament);
    }
}
