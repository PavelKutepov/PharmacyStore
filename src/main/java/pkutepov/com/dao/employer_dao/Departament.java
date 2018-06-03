package pkutepov.com.dao.employer_dao;

public class Departament {

    private int departamentId;

    private String name;

    private String position;

    public Departament(int departamentId, String name, String position) {
        this.departamentId = departamentId;
        this.name = name;
        this.position = position;
    }

    public Departament(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public int getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(int departamentId) {
        this.departamentId = departamentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
