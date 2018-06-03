package pkutepov.com.dao.employer_dao;

import pkutepov.com.dao.user_dao.User;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Override
    public void addEmployee(User user, Departament departament) {
        employeeDao.addEmployee(user, departament);
    }

    @Override
    public void delEmployee(User user) {

    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
