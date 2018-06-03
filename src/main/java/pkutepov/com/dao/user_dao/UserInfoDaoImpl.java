package pkutepov.com.dao.user_dao;

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
public class UserInfoDaoImpl extends NamedParameterJdbcDaoSupport implements UserInfoDao {

    private UserInfoDao userInfoDao;

    @Override
    @Transactional(readOnly = true)
    public List<UserInfo> getAllUserInfo() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.user_info ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new UserInfoRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public UserInfo getUserInfoById(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.user_info WHERE user_id = ").append(userId);
        return getJdbcTemplate().queryForObject(sql.toString(), new UserInfoRowMapper());

    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserInfo addUserInfo(String lastname, String firstname, String patronymic, String phoneNumber) {
        StringBuilder sql = new StringBuilder();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("lastname", lastname);
        mapSqlParameterSource.addValue("firstname", firstname);
        mapSqlParameterSource.addValue("patronymic", patronymic);
        mapSqlParameterSource.addValue("phoneNumber", phoneNumber);
        sql.append("INSERT INTO pharmacydatabase.user_info ( lastname,firstname,patronymic,phone_number)")
                .append("VALUES( ")
                .append(" :lastname, ")
                .append(" :firstname ,")
                .append(" :patronymic ,")
                .append(" :phoneNumber  )");
        getNamedParameterJdbcTemplate().update(sql.toString(), mapSqlParameterSource, keyHolder);

        return new UserInfo(keyHolder.getKey().intValue(), lastname, firstname, patronymic, phoneNumber);
    }

    private class UserInfoRowMapper implements RowMapper<UserInfo> {


        @Override
        public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new UserInfo(rs.getInt("user_id"), rs.getString("lastname"),
                    rs.getString("firstname"), rs.getString("patronymic"), rs.getString("phone_number"));

        }
    }
}
