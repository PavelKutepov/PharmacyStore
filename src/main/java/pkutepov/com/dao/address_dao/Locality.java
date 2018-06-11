package pkutepov.com.dao.address_dao;

import java.util.Objects;


public class Locality {
    private int localityId;

    private String city;

    private String district;

    private String local;

    public Locality(int locality_id, String city, String district, String local) {
        this.localityId = locality_id;
        this.city = city;
        this.district = district;
        this.local = local;
    }

    public Locality(String city, String district, String local) {
        this.city = city;
        this.district = district;
        this.local = local;
    }

    public int getLocality_id() {
        return localityId;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getLocal() {
        return local;
    }

    public void setLocalityId(int localityId) {
        this.localityId = localityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locality)) return false;
        Locality locality = (Locality) o;
        return Objects.equals(city, locality.city) &&
                Objects.equals(district, locality.district) &&
                Objects.equals(local, locality.local);
    }

    @Override
    public int hashCode() {

        return Objects.hash(city, district, local);
    }

    @Override
    public String toString() {
        return "г. " + city + " " + district + " " + local;
    }
}
