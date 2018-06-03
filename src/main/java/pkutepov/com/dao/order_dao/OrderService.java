package pkutepov.com.dao.order_dao;

import org.springframework.stereotype.Service;
import pkutepov.com.dao.address_dao.Address;
import pkutepov.com.dao.employer_dao.Employee;
import pkutepov.com.dao.medicine_dao.Medicine;
import pkutepov.com.dao.user_dao.UserInfo;


import java.util.Date;
import java.util.List;

@Service
public interface OrderService {
    List<Order> getOrderList();

    List<Order> getOrderListByOrderInfoId(int orderInfoId);

    Order getOrderById(int orderId);

    OrderInfo addOrderInfo(UserInfo userInfo, Employee employee, Address address, Date date);

    Order addOrder(Medicine medicine, OrderInfo orderInfo, int count);

    OrderInfo getOrderInfoById(int orderInfoId);

    List<OrderInfo> getAllOrderInfo();
}
