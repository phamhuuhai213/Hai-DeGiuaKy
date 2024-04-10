package QuanLyXe;

import java.io.Serializable;

public class Oto extends Car implements Serializable {
    private int slots;
    private String engineType;

    public Oto(int ID, String name, String brand, String publishYear, String price, String color, int slots, String engineType) {
        super(ID, name, brand, publishYear, price, color);
        this.slots = slots;
        this.engineType = engineType;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("So cho ngoi: " + slots);
        System.out.println("Kieu dong co: " + engineType);
    }
}