package pkutepov.com.dao.user_dao;


import pkutepov.com.dao.role.Role;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserServiceImpl implements UserService {


    private UserDao userDao;
    private UserInfoDao userInfoDao;

    @Override
    public User addUser(String login, String password, UserInfo userInfo) {
        return userDao.addUser(login, password, userInfo);
    }

    @Override
    public UserInfo addUserInfo(String lastName, String firstName, String patronymic, String phoneNumber) {
        return userInfoDao.addUserInfo(lastName, firstName, patronymic, phoneNumber);
    }

    @Override
    public Set<User> getUserByRoleId(int roleId) {
        Set<User> userSet = new HashSet<>();
       List<User> users= userDao.getAllUsers();
       for(User user:users){
           for(Role role:user.getRoles()){
               if(role.getRoleId()==roleId){
                   userSet.add(user);
               }
           }
       }
        return userSet;
    }

    @Override
    public void removeUser(String login, String password) {
    }

    @Override
    public User getUserByLogin(String login) {
        return  userDao.getUserByLogin(login);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<UserInfo> getAllUsersInfo() {
        return userInfoDao.getAllUserInfo();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public UserInfo getUserInfoById(int userId) {
        return userInfoDao.getUserInfoById(userId);
    }
}
