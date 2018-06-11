package pkutepov.com.dao.order_dao;

import pkutepov.com.dao.address_dao.Address;
import pkutepov.com.dao.address_dao.AddressService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private OrderInfoDao orderInfoDao;
    private AddressService addressService;

    @Override
    public List<Order> getOrderList() {
        return orderDao.getOrderList();
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }

    @Override
    public OrderInfo addOrderInfo(OrderInfo orderInfo) {
        Address address = addressService.addAdress(orderInfo.getAddress());
        orderInfo.setAddress(address);
        return orderInfoDao.addOrderInfo(orderInfo);
    }

    @Override
    public List<OrderInfo> getOrderInfoByUserId(int userId) {
        return orderInfoDao.getOrderInfoByUserId(userId);
    }

    @Override
    public Order addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public void addOrderList(List<Order> orders, OrderInfo orderInfo) {
        OrderInfo orderInfoRes = addOrderInfo(orderInfo);

        for (Order order : orders) {
            order.setOrderInfo(orderInfoRes);
            addOrder(order);
        }

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

    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }
}

