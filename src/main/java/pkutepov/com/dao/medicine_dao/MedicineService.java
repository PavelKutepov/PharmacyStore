package pkutepov.com.dao.medicine_dao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicineService {
    void addMedicine(String name, String firm, String type, double price);

    void delMebicine(Medicine medicine);

    List<Medicine> getAllMedicine();

    Medicine getMedecineById(int medecineId);
}
