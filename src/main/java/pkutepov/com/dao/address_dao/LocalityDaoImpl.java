package pkutepov.com.dao.address_dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class LocalityDaoImpl extends NamedParameterJdbcDaoSupport implements LocalityDao {


    @Override
    @Transactional(readOnly = true)
    public List<Locality> getAllLocality() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.locality ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new LocalityRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public Locality addLocality(Locality locality) {
        StringBuilder sql = new StringBuilder();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("city", locality.getCity());
        mapSqlParameterSource.addValue("district", locality.getDistrict());
        mapSqlParameterSource.addValue("local", locality.getLocal());

        sql.append("INSERT INTO pharmacydatabase.locality ( city, district, local ) ")
                .append("VALUES( ")
                .append(" :city, ")
                .append(" :district,")
                .append(" :local )");
        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource, keyHolder);
        locality.setLocalityId(keyHolder.getKey().intValue());
        return new Locality(keyHolder.getKey().intValue(), locality.getCity(), locality.getDistrict(), locality.getLocal());
    }

    @Override
    @Transactional(readOnly = true)
    public Locality getLocalityById(int localityId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.locality WHERE locality_id = ").append(localityId);
        return getJdbcTemplate().queryForObject(sql.toString(), new LocalityRowMapper());
    }

    private class LocalityRowMapper implements RowMapper<Locality> {

        @Override
        public Locality mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new Locality(rs.getInt("locality_id"), rs.getString("city"),
                    rs.getString("district"), rs.getString("local"));

        }
    }
}
