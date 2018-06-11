package pkutepov.com.dao.order_dao;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pkutepov.com.dao.medicine_dao.Medicine;
import pkutepov.com.dao.medicine_dao.MedicineService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class OrderDaoImpl extends NamedParameterJdbcDaoSupport implements OrderDao {

    private MedicineService medicineService;
    private OrderInfoDao orderInfoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrderList() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.order ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new OrderRowMapper());
    }


    @Override
    @Transactional(readOnly = true)
    public Order getOrderById(int orderId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.order WHERE order_id = ").append(orderId);
        return getJdbcTemplate().queryForObject(sql.toString(), new OrderRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public Order addOrder(Order order) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("medicine_id", order.getMedicine().getMedicine_id());
        mapSqlParameterSource.addValue("order_info_id", order.getOrderInfo().getOrderInfoId());
        mapSqlParameterSource.addValue("count", order.getCount());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO pharmacydatabase.order (medicine_id,order_info_id,count) ")
                .append("VALUES( ")
                .append(" :medicine_id , ")
                .append(" :order_info_id , ")
                .append(" :count)");
        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource, keyHolder);
        Order ordeRes = new Order(keyHolder.getKey().intValue(), order.getMedicine(), order.getOrderInfo(), order.getCount());
        return ordeRes;
    }

    @Transactional(readOnly = true)
    public List<Order> getOrderListByOrderInfoId(int orderInfoId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.order WHERE order_info_id = ").append(orderInfoId);
        return getJdbcTemplate().query(sql.toString(), new OrderRowMapper());
    }

    public void setMedicineService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void setOrderInfoDao(OrderInfoDao orderInfoDao) {
        this.orderInfoDao = orderInfoDao;
    }

    private class OrderRowMapper implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            int medicineId = rs.getInt("medicine_id");
            int orderInfoId = rs.getInt("order_info_id");
            OrderInfo orderInfo = orderInfoDao.getOrderInfoById(orderInfoId);
            Medicine medicine = medicineService.getMedecineById(medicineId);
            return new Order(rs.getInt("order_id"), medicine, orderInfo, rs.getInt("count"));

        }
    }
}
