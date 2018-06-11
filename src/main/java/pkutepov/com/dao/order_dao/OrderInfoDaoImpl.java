package pkutepov.com.dao.order_dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pkutepov.com.dao.address_dao.Address;
import pkutepov.com.dao.address_dao.AddressService;
import pkutepov.com.dao.employer_dao.EmployeeService;
import pkutepov.com.dao.user_dao.UserInfo;
import pkutepov.com.dao.user_dao.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class OrderInfoDaoImpl extends NamedParameterJdbcDaoSupport implements OrderInfoDao {

    private UserService userService;
    private EmployeeService employeeService;
    private AddressService addressService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderInfo> getAllOrderInfo() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.order_info ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new OrderInfoRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public OrderInfo getOrderInfoById(int orderInfoId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.order_info WHERE order_info_id = ").append(orderInfoId);
        return getJdbcTemplate().queryForObject(sql.toString(), new OrderInfoRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderInfo> getOrderInfoByUserId(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.order_info WHERE user_info_id = ").append(userId);
        return getJdbcTemplate().query(sql.toString(), new OrderInfoRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public OrderInfo addOrderInfo(OrderInfo orderInfo) {
        StringBuilder sql = new StringBuilder();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_info_id", orderInfo.getUserInfo().getUserInfoId());
        mapSqlParameterSource.addValue("address_id", orderInfo.getAddress().getAddressId());
        mapSqlParameterSource.addValue("date", orderInfo.getDate());
        sql.append("INSERT INTO pharmacydatabase.order_info ( user_info_id, address_id, date)")
                .append("VALUES( ")
                .append(" :user_info_id, ")
                .append(" :address_id, ")
                .append(" :date )");
        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource, keyHolder);
        OrderInfo resultOrder = new OrderInfo(keyHolder.getKey().intValue(), orderInfo.getUserInfo(), orderInfo.getAddress(), orderInfo.getDate());
        return resultOrder;
    }

    private class OrderInfoRowMapper implements RowMapper<OrderInfo> {


        @Override
        public OrderInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            int userInfoId = rs.getInt("user_info_id");
            int addressId = rs.getInt("address_id");
            UserInfo userInfo = userService.getUserInfoById(userInfoId);
            Address address = addressService.getAddressForId(addressId);
            return new OrderInfo(rs.getInt("order_info_id"), userInfo, address, rs.getDate("date"));

        }
    }
}
