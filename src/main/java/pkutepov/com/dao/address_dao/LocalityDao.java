package pkutepov.com.dao.address_dao;

import java.util.List;

public interface LocalityDao {

    List<Locality> getAllLocality();

    Locality getLocalityById(int localityId);

    Locality addLocality(Locality locality);
}
