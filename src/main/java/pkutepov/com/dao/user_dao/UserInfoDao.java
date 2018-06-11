package pkutepov.com.dao.user_dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserInfoDao {
    List<UserInfo> getAllUserInfo();

    UserInfo getUserInfoById(int userId);

    UserInfo addUserInfo(UserInfo userInfo);

}

