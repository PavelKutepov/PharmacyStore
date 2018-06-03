package pkutepov.com.dao.order_dao;

import pkutepov.com.dao.address_dao.Address;
import pkutepov.com.dao.employer_dao.Employee;
import pkutepov.com.dao.user_dao.UserInfo;


import java.util.Date;
import java.util.List;

public interface OrderInfoDao {
    List<OrderInfo> getAllOrderInfo();

    OrderInfo getOrderInfoById(int orderInfo);

    OrderInfo addOrderInfo(UserInfo userInfo, Employee employee, Address address, Date date);
}
