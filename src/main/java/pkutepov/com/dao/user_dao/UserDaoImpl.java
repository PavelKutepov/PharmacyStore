package pkutepov.com.dao.user_dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pkutepov.com.dao.role.Role;
import pkutepov.com.dao.role.RoleDao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Transactional(isolation = Isolation.READ_COMMITTED,readOnly = true)
public class UserDaoImpl extends NamedParameterJdbcDaoSupport implements UserDao {

    private UserDao userDao;
    private UserInfoDao userInfoDao;
    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.user ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new UserRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.user WHERE user_id = ").append(userId);
        return getJdbcTemplate().queryForObject(sql.toString(), new UserRowMapper());
    }
    @Override
    @Transactional(readOnly = true)
    public User addUser(String login, String password, UserInfo userInfo) {
        userInfo= userInfoDao.addUserInfo(userInfo.getLastName(),userInfo.getFirstName(),userInfo.getPatronymic(),userInfo.getPhoneNumber());
        StringBuilder sql = new StringBuilder();

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_id", userInfo.getUserInfoId());
        mapSqlParameterSource.addValue("login", login);
        mapSqlParameterSource.addValue("password", password);

        sql.append("INSERT INTO pharmacydatabase.user  (user_id,login,password)")
                .append("VALUES( ")
                .append(" :user_id , ")
                .append(" :login, ")
                .append(" :password )");
        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource);
        Role role = roleDao.getRoleById(1);
        Set<Role>roles =new HashSet<>();
        roles.add(role);
        User newUser = new User(userInfo.getUserInfoId(), login, password, userInfo,roles);
        roleDao.addRole(newUser,role);

        return newUser;
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByLogin(String login) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.user WHERE login = ").append(login);
        return getJdbcTemplate().queryForObject(sql.toString(), new UserRowMapper());
    }

    @Transactional(readOnly = true)
    public void removeUser(String login, String password) {

    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    private class UserRowMapper implements RowMapper<User> {



        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            int userId=rs.getInt("user_id");
            UserInfo userInfo = userInfoDao.getUserInfoById(userId);
            Set<Role> roles=new HashSet<>();
            roles.addAll(roleDao.getAllRolesByUser(userId));
            return new User(rs.getInt("user_id"), rs.getString("login"), rs.getString("password"), userInfo,roles);
        }
    }
}
