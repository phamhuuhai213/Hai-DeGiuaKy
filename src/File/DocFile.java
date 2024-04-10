package File;

import QuanLyXe.Car;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DocFile {
    public static List<Car> readCarsFromFile(String filename) {
        List<Car> cars = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            // Đọc danh sách các phương tiện xe từ tệp tin
            cars = (List<Car>) objectIn.readObject();
            System.out.println("Danh sách các phương tiện xe đã được đọc từ file '" + filename + "'.");

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return cars;
    }
}