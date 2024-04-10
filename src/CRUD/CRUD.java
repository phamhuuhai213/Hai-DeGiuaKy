/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import QuanLyXe.Car;
import java.util.ArrayList;
import java.util.List;




public class CRUD {
    private List<Car> cars;

    public CRUD() {
        this.cars = new ArrayList<>(); // Khởi tạo danh sách cars
    }

    public CRUD(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void displayAllCar() {
        if (cars == null) {
            System.out.println("No cars available.");
            return;
        }
        for (Car car : cars) {
            car.showInfo();
        }
    }

    public Car findCarById(int id) {
        if (cars == null) {
            return null;
        }
        for (Car car : cars) {
            if (car.getID() == id) {
                return car;
            }
        }
        return null;
    }

    public void updateCar(int id, Car updatedCar) {
    if (cars == null) {
        System.out.println("No cars available."); // Hiển thị thông báo nếu danh sách xe trống
        return;
    }
    
    for (int i = 0; i < cars.size(); i++) {
        if (cars.get(i).getID() == id) { 
            cars.set(i, updatedCar); 
            System.out.println("Car with ID " + id + " updated successfully."); 
            return;
        }
    }
    
    
    System.out.println("Car with ID " + id + " not found.");
}

    public void deleteCar(int id) {
        if (cars == null) {
            System.out.println("No cars available.");
            return;
        }
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getID() == id) {
                cars.remove(i);
                break;
            }
        }
    }
}
