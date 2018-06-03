package pkutepov.com.dao.order_dao;


import pkutepov.com.dao.medicine_dao.Medicine;

public class Order {

    private int orderId;

    private Medicine medicine;

    private OrderInfo orderInfo;

    private int count;

    public Order(int orderId, Medicine medicine, OrderInfo orderInfo, int count) {
        this.orderId = orderId;
        this.medicine = medicine;
        this.orderInfo = orderInfo;
        this.count = count;
    }

    public Order(Medicine medicine, OrderInfo orderInfo, int count) {
        this.medicine = medicine;
        this.orderInfo = orderInfo;
        this.count = count;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
