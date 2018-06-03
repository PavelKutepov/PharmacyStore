package pkutepov.com.dao.medicine_dao;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    private MedicineDao medicineDao;

    @Override

    public void addMedicine(String name, String firm, String type, double price) {
        medicineDao.addMedicine(name, firm, type, price);
    }

    @Override
    public void delMebicine(Medicine medicine) {
        medicineDao.delMebicine(medicine);
    }

    @Override
    public List<Medicine> getAllMedicine() {
        return medicineDao.getAllMedicine();
    }

    @Override
    public Medicine getMedecineById(int medecineId) {
        return medicineDao.getMedecineById(medecineId);
    }

    public void setMedicineDao(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }
}
