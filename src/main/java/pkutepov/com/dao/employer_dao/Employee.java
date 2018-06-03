package pkutepov.com.dao.employer_dao;


import pkutepov.com.dao.user_dao.User;

public class Employee {

    private int employeeId;

    private User user;

    private Departament departament;


    public Employee(int employeeId, User user, Departament departament) {
        this.employeeId = employeeId;
        this.user = user;
        this.departament = departament;
    }

    public Employee(User user, Departament departament) {
        this.user = user;
        this.departament = departament;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }
}
