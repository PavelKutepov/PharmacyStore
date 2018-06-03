package pkutepov.com.dao.order_dao;

import pkutepov.com.dao.address_dao.Address;
import pkutepov.com.dao.employer_dao.Employee;
import pkutepov.com.dao.medicine_dao.Medicine;
import pkutepov.com.dao.user_dao.UserInfo;


import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private OrderInfoDao orderInfoDao;

    @Override
    public List<Order> getOrderList() {
        return orderDao.getOrderList();
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }

    @Override
    public OrderInfo addOrderInfo(UserInfo userInfo, Employee employee, Address address, Date date) {
        return orderInfoDao.addOrderInfo(userInfo, employee, address, date);
    }

    @Override
    public Order addOrder(Medicine medicine, OrderInfo orderInfo, int count) {
        return orderDao.addOrder(medicine, orderInfo, count);
    }

    @Override
    public OrderInfo getOrderInfoById(int orderInfoId) {
        return orderInfoDao.getOrderInfoById(orderInfoId);
    }

    @Override
    public List<Order> getOrderListByOrderInfoId(int orderInfoId) {
        return orderDao.getOrderListByOrderInfoId(orderInfoId);
    }

    @Override
    public List<OrderInfo> getAllOrderInfo() {
        return orderInfoDao.getAllOrderInfo();
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setOrderInfoDao(OrderInfoDao orderInfoDao) {
        this.orderInfoDao = orderInfoDao;
    }
}

