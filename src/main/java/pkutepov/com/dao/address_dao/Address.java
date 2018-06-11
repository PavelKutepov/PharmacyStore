package pkutepov.com.dao.address_dao;

public class Address {
    private int addressId;

    private String street;

    private int house;

    private int apartment;

    private Locality locality;

    public Address(int addressId, String street, int house, int apartment, Locality locality) {
        this.addressId = addressId;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.locality = locality;
    }

    public Address(String street, int house, int apartment, Locality locality) {
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.locality = locality;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "ул." + street + " д." + house + "кв." + apartment + locality;

    }
}
