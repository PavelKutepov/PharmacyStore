package pkutepov.com.dao.medicine_dao;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class MedicineDaoImpl extends NamedParameterJdbcDaoSupport implements MedicineDao {

    @Override
    @Transactional(readOnly = true)
    public void addMedicine(String name, String firm, String type, double price) {
        StringBuilder sql = new StringBuilder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name",name);
        mapSqlParameterSource.addValue("firm",firm);
        mapSqlParameterSource.addValue("type",type);
        mapSqlParameterSource.addValue("price",price);

        sql.append("INSERT INTO pharmacydatabase.medicine (name,firm,type,price) ")
                .append("VALUES( ")
                .append(" :name, ")
                .append(" :firm, ")
                .append(" :type, ")
                .append(" :price )");

        getNamedParameterJdbcTemplate().update(sql.toString(),mapSqlParameterSource);
    }

    @Override
    @Transactional(readOnly = true)
    public void delMebicine(Medicine medicine) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM pharmacydatabase.medicine WHERE medicine_id = ").append(medicine.getMedicine_id());
        getJdbcTemplate().update(sql.toString());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Medicine> getAllMedicine() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.medicine ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new MedicineRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public Medicine getMedecineById(int medecineId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.medicine WHERE medicine_id = ").append(medecineId);
        return getJdbcTemplate().queryForObject(sql.toString(), new MedicineRowMapper());
    }

    private class MedicineRowMapper implements RowMapper<Medicine> {

        @Override
        public Medicine mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new Medicine(rs.getInt("medicine_id"), rs.getString("name"),
                    rs.getString("firm"), rs.getString("type"),
                    rs.getInt("price"));

        }
    }
}
