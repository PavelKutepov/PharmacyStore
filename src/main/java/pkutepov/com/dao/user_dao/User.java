package pkutepov.com.dao.user_dao;


import pkutepov.com.dao.role.Role;

import javax.persistence.Transient;
import java.util.Set;

public class User {
    private final int userId;
    private final String login;

    private final String password;
    private final UserInfo userInfo;
    @Transient
    private String confirmPassword;
    private Set<Role> roles;

    public User(int userId, String login, String password, UserInfo userInfo) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.userInfo = userInfo;
    }


    public User(int userId, String login, String password, UserInfo userInfo, Set<Role> roles) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.userInfo = userInfo;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getRolesToString() {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (Role role : roles) {
            sb.append(sep).append(role.getName());
            sep = ", ";
        }
        return sb.toString();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public int getUserId() {
        return userId;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
