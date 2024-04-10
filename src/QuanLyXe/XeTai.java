package QuanLyXe;

import java.io.Serializable;

public class XeTai extends Car implements Serializable {
    private String loadWeight;

    public XeTai(int ID, String Name, String brand, String publishYear, String price, String color, String loadWeight) {
        super(ID, Name, brand, publishYear, price, color);
        this.loadWeight = loadWeight;
    }

    public String getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(String loadWeight) {
        this.loadWeight = loadWeight;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Trong tai: " + loadWeight);
    }
}