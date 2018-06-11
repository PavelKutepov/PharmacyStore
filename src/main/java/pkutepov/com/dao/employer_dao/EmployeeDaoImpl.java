package pkutepov.com.dao.employer_dao;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pkutepov.com.dao.user_dao.User;
import pkutepov.com.dao.user_dao.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class EmployeeDaoImpl extends NamedParameterJdbcDaoSupport implements EmployeeDao {

    private UserService userService;
    private DepartamentDao departamentDao;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setDepartamentDao(DepartamentDao departamentDao) {
        this.departamentDao = departamentDao;
    }

    @Override
    @Transactional(readOnly = true)
    public void addEmployee(User user, Departament departament) {
        StringBuilder sql = new StringBuilder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("departament_id", departament.getDepartamentId());
        mapSqlParameterSource.addValue("user_id", user.getUserId());
        sql.append("INSERT INTO pharmacydatabase.employee (user_id, departament_id)  ")
                .append("VALUES( ")
                .append(" :user_id, ")
                .append(" :departament_id )");
        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource);

    }

    @Override
    @Transactional(readOnly = true)
    public void delEmployee(User user) {

    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployee() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.employee ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new EmployeeRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployeeById(int employeeId) {
        StringBuilder sql = new StringBuilder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("employee_id", employeeId);
        sql.append("SELECT * FROM pharmacydatabase.employee WHERE employee_id = :employee_id ");
        return getNamedParameterJdbcTemplate().queryForObject(sql.toString(), mapSqlParameterSource, new EmployeeRowMapper());
    }

    private class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            int userId = rs.getInt("user_id");
            int departamentId = rs.getInt("departament_id");
            Departament departament = departamentDao.getDepartamentById(departamentId);
            User user = userService.getUserById(userId);
            return new Employee(rs.getInt("employee_id"), user, departament);

        }
    }
}
