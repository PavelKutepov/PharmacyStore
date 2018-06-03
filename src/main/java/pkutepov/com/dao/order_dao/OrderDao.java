package pkutepov.com.dao.order_dao;

import pkutepov.com.dao.medicine_dao.Medicine;


import java.util.List;

public interface OrderDao {

    List<Order> getOrderList();

    List<Order> getOrderListByOrderInfoId(int orderInfoId);

    Order getOrderById(int orderId);

    Order addOrder(Medicine medicine, OrderInfo orderInfo, int count);
}
