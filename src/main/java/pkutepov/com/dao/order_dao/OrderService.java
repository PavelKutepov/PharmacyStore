package pkutepov.com.dao.order_dao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getOrderList();

    List<Order> getOrderListByOrderInfoId(int orderInfoId);

    Order getOrderById(int orderId);

    OrderInfo addOrderInfo(OrderInfo orderInfo);

    Order addOrder(Order order);

    List<OrderInfo> getOrderInfoByUserId(int userId);

    OrderInfo getOrderInfoById(int orderInfoId);

    void addOrderList(List<Order> orders, OrderInfo orderInfo);

    List<OrderInfo> getAllOrderInfo();
}
