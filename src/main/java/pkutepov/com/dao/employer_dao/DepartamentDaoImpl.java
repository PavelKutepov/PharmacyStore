package pkutepov.com.dao.employer_dao;


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
public class DepartamentDaoImpl extends NamedParameterJdbcDaoSupport implements DepartamentDao {


    @Override
    @Transactional(readOnly = true)
    public List<Departament> getAllDepartament() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.departament  ");
        return getJdbcTemplate().query(sql.toString(), new DepartamentRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public Departament getDepartamentById(int departamentId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.departament WHERE departament_id = ").append(departamentId);
        return getJdbcTemplate().queryForObject(sql.toString(), new DepartamentRowMapper());

    }

    @Override
    @Transactional(readOnly = true)
    public void addDepartament(String name, String position) {
        StringBuilder sql = new StringBuilder();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", name);
        mapSqlParameterSource.addValue("position", position);
        sql.append("INSERT INTO pharmacydatabase.departament (name, position)")
                .append("VALUES( ")
                .append(":name, ")
                .append(":position )");
        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource, keyHolder);
    }

    private class DepartamentRowMapper implements RowMapper<Departament> {

        @Override
        public Departament mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new Departament(rs.getInt("departament_id"),
                    rs.getString("name"), rs.getString("position"));

        }
    }
}
