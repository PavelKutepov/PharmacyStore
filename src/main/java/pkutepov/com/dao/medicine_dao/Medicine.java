package pkutepov.com.dao.medicine_dao;

public class Medicine {

    private int medicine_id;
    private String name;
    private String firm;
    private String type;
    private double price;


    public Medicine(int medicine_id, String name, String firm, String type, int price) {
        this.medicine_id = medicine_id;
        this.name = name;
        this.firm = firm;
        this.type = type;
        this.price = price;


    }

    public Medicine(String name, String firm, String type, int price) {
        this.name = name;
        this.firm = firm;
        this.type = type;
        this.price = price;

    }

    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Medicine" + name + firm + type + price;
    }


}
