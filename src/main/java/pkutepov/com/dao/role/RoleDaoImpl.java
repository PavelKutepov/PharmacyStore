package pkutepov.com.dao.role;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pkutepov.com.dao.user_dao.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class RoleDaoImpl extends NamedParameterJdbcDaoSupport implements RoleDao {


    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRolesByUser(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT rsu.user_id,rsu.role_id, rs.name_role FROM pharmacydatabase.role_users AS rsu JOIN pharmacydatabase.roles AS rs ON rsu.role_id=rs.role_id AND rsu.user_id=").append(userId);
        return getJdbcTemplate().query(sql.toString(), new RoleRowMapper());
    }


    @Override
    public String getRoleNameById(int roleId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.roles WHERE id =").append(roleId);
        return getJdbcTemplate().query(sql.toString(), Object::toString);

    }
//    @Override
//    @Transactional(readOnly = true)
//    public Role getRoleByLogin(String roleLogin) {
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT * FROM pharmacydatabase.role WHERE login = ").append(roleLogin);
//        return getNamedParameterJdbcTemplate().queryForObject(sql.toString(), new HashMap<>(), new RoleRowMapper());
//    }

    @Override
    @Transactional(readOnly = true)
    public void addRole(User user, Role role) {
        StringBuilder sql = new StringBuilder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_id", user.getUserId());
        mapSqlParameterSource.addValue("role_id", role.getRoleId());
        sql.append("INSERT INTO pharmacydatabase.role_users (user_id,role_id) VALUES( ")
                .append(" :user_id, ")
                .append(" :role_id ")
                .append(" )");
        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource);
    }


    @Override
    @Transactional(readOnly = true)
    public Role getRoleById(int roleId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.roles WHERE role_id=").append(roleId);
        return getJdbcTemplate().queryForObject(sql.toString(), new RoleRowMapper());
    }

    @Override
    public void removeRoleInUser(User user, Role role) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_id", user.getUserId());
        mapSqlParameterSource.addValue("role_id", role.getRoleId());
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM pharmacydatabase.role_users WHERE ")
                .append(" user_id= :user_id AND ")
                .append(" role_id= :role_id ");

        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource);
    }

    private class RoleRowMapper implements RowMapper<Role> {


        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            int roleId = rs.getInt("role_id");
            String name = rs.getString("name_role");
            return new Role(roleId, name);

        }
    }

}
