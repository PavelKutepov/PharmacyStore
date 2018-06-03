package pkutepov.com.dao.order_dao;


import pkutepov.com.dao.address_dao.Address;
import pkutepov.com.dao.employer_dao.Employee;
import pkutepov.com.dao.user_dao.UserInfo;


import java.util.Date;

public class OrderInfo {

    private int orderInfoId;

    private UserInfo userInfo;

    private Employee employee;

    private Address address;

    private Date date;


    public OrderInfo(int orderInfoId, UserInfo userInfo, Employee employee, Address address, Date date) {
        this.orderInfoId = orderInfoId;
        this.userInfo = userInfo;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
