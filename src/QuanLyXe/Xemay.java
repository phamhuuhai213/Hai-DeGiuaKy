package QuanLyXe;

import java.io.Serializable;

public class Xemay extends Car implements Serializable {
    private String capacity;

    public Xemay(int ID, String Name, String brand, String publishYear, String price, String color, String capacity) {
        super(ID, Name, brand, publishYear, price, color);
        this.capacity = capacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Cong Suat: " + capacity);
    }
}