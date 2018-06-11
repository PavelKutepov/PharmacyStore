package pkutepov.com.dao.order_dao;


import pkutepov.com.dao.address_dao.Address;
import pkutepov.com.dao.user_dao.UserInfo;

import java.util.Date;

public class OrderInfo {

    private int orderInfoId;

    private UserInfo userInfo;

    private Address address;

    private Date date;


    public OrderInfo(int orderInfoId, UserInfo userInfo, Address address, Date date) {
        this.orderInfoId = orderInfoId;
        this.userInfo = userInfo;

        this.address = address;
        this.date = date;
    }

    public OrderInfo(UserInfo userInfo, Address address, Date date) {
        this.userInfo = userInfo;
        this.address = address;
        this.date = date;
    }

    public int getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(int orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
