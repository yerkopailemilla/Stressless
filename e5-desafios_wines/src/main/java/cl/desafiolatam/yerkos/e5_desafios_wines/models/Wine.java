package cl.desafiolatam.yerkos.e5_desafios_wines.models;

import com.orm.SugarRecord;

public class Wine extends SugarRecord {

    private String brand, type;
    private String years;

    public Wine() {
    }

    public Wine(String brand, String type, String years) {
        this.brand = brand;
        this.type = type;
        this.years = years;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
}
