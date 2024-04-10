package QuanLyXe;

import java.io.Serializable;

public class Car implements Icar, Serializable {
    private int ID;
    private String Name;
    private String brand;
    private String publishYear;
    private String price;
    private String color;

    public Car(int ID, String Name, String brand, String publishYear, String price, String color) {
        this.ID = ID;
        this.Name = Name;
        this.brand = brand;
        this.publishYear = publishYear;
        this.price = price;
        this.color = color;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Ten xe: " + Name);
        System.out.println("Hang san xuat: " + brand);
        System.out.println("Nam san xuat: " + publishYear);
        System.out.println("Gia: " + price);
        System.out.println("Mau xe: " + color);
    }
}