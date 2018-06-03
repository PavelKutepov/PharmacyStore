package test_dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkutepov.com.dao.address_dao.AddressService;
import pkutepov.com.dao.employer_dao.EmployeeService;
import pkutepov.com.dao.medicine_dao.MedicineService;
import pkutepov.com.dao.order_dao.Order;
import pkutepov.com.dao.order_dao.OrderInfo;
import pkutepov.com.dao.order_dao.OrderService;
import pkutepov.com.dao.user_dao.UserService;


import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/testApplicationContext.xml")
public class TestOrderDao {
    @Autowired
   private MedicineService medicineService;
    @Autowired
   private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;


    @Test
    public void orderServiceTest(){
//        System.out.println("orderServiceTest");
//        Date date = new Date();
//        UserInfo userInfo = userService.getUserInfoById(49);
//        Medicine medicine = medicineService.getMedecineById(1);
//        System.out.println("medicine");
//        Employee employee = employeeService.getEmployeeById(1);
//        System.out.println("Address");
//        Address address = addressService.getAddressForId(3);
//        OrderInfo orderInfo = orderService.addOrderInfo(userInfo,employee,address,date);
//      Order order= orderService.addOrder(medicine,orderInfo,45);
//        assertNotNull(order);
    }
    @Test
    public void orderServiceGetTest(){
       List<OrderInfo> orderInfos= orderService.getAllOrderInfo();
       assertNotNull(orderInfos);
        System.out.println("orderInfos");
        OrderInfo orderInfo = orderService.getOrderInfoById(2);
        assertNotNull(orderInfo);
        System.out.println("orderInfo");
        List<Order> orders= orderService.getOrderList();
        assertNotNull(orders);
        System.out.println("orders");
        Order order = orderService.getOrderById(1);
        assertNotNull(order);
        System.out.println("order");
    }
}
