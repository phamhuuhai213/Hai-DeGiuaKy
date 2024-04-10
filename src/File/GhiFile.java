package File;

import QuanLyXe.Car;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GhiFile {
    public static void writeCarsToFile(List<Car> cars, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Car car : cars) {
                // Ghi từng thuộc tính của mỗi đối tượng Car vào file
                writer.write(car.getID() + "," + car.getName() + "," + car.getBrand() + "," +
                        car.getPublishYear() + "," + car.getPrice() + "," + car.getColor());
                writer.newLine(); // Xuống dòng sau khi ghi xong một đối tượng Car
            }
            System.out.println("Danh sách các phương tiện xe đã được ghi vào file '" + filename + "'.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}