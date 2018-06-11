package pkutepov.com.dao.order_dao;

import java.util.List;

public interface OrderDao {

    List<Order> getOrderList();

    List<Order> getOrderListByOrderInfoId(int orderInfoId);

    Order getOrderById(int orderId);

    Order addOrder(Order order);
}
