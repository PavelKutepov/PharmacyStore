package pkutepov.com.dao.role;

import pkutepov.com.dao.user_dao.User;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRolesByUser(int userId);

    String getRoleNameById(int roleId);

    void addRole(User user, Role role);

    void removeRoleInUser(User user, Role role);

    Role getRoleById(int roleId);
}
