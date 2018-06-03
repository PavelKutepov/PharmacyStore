package pkutepov.com.dao.medicine_dao;

import java.util.List;

public interface MedicineDao {
    void addMedicine(String name, String firm, String type, double price);

    void delMebicine(Medicine medicine);

    List<Medicine> getAllMedicine();

    Medicine getMedecineById(int medecineId);
}
