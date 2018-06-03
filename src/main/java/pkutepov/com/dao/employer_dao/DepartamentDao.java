package pkutepov.com.dao.employer_dao;

import java.util.List;

public interface DepartamentDao {
    List<Departament> getAllDepartament();

    Departament getDepartamentById(int departamentId);

    void addDepartament(String name, String position);
}
