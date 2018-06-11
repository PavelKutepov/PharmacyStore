package pkutepov.com.dao.user_dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    User addUser(String login, String password, UserInfo userInfo);

    void removeUser(String login, String password);

    List<User> getAllUsers();

    User getUserById(int userId);

    User getUserByLogin(String login);

}
