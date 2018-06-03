package pkutepov.com.dao.role;

public class Role {

    int roleId;

    String name;



    public Role() {

    }

    public Role(int roleId, String name) {
        this.roleId = roleId;
        this.name = name;

    }

    public Role(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String login) {
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


}
