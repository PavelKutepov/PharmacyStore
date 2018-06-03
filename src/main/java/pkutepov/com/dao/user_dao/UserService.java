package pkutepov.com.dao.user_dao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {

    User addUser(String login, String password, UserInfo userInfo);

    void removeUser(String login, String password);

    List<User> getAllUsers();

    User getUserById(int userId);

    List<UserInfo> getAllUsersInfo();

    User getUserByLogin(String login);

    UserInfo getUserInfoById(int userId);

    Set<User> getUserByRoleId(int roleId);

    UserInfo addUserInfo(String lastName, String firstName, String patronymic, String phoneNumber);
}
