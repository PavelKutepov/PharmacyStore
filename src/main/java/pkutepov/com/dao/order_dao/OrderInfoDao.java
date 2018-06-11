package pkutepov.com.dao.order_dao;

import java.util.List;

public interface OrderInfoDao {
    List<OrderInfo> getAllOrderInfo();

    OrderInfo getOrderInfoById(int orderInfo);

    List<OrderInfo> getOrderInfoByUserId(int userId);

    OrderInfo addOrderInfo(OrderInfo orderInfo);
}
