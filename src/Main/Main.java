package Main;

import CRUD.CRUD;
import QuanLyXe.Car;
import QuanLyXe.Oto;
import QuanLyXe.XeTai;
import QuanLyXe.Xemay;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CRUD quanlyXe = new CRUD();
        Scanner scanner = new Scanner(System.in);

        boolean stop = true;
        do {
            System.out.println("----------------------------- Quan Ly Xe ----------------------------");
            System.out.println("1. Them  phuong tien xe");
            System.out.println("2. Hien thi danh sach phuong tien xe");
            System.out.println("3. Tim phuong tien xe theo ID");
            System.out.println("4. Xoa phuong tien xe");
            System.out.println("5. Ghi danh sach phuong tien xe vao file");
            System.out.println("6. Doc danh sach phuong tien xe tu file");
            System.out.println("7. Thoat");
            System.out.println("");
            System.out.print("Nhap lua chon cua ban: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Thêm xe
                    System.out.println("Nhap thong tin phuong tien xe moi:");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Hang san xuat: ");
                    String brand = scanner.nextLine();

                    System.out.print("Nam san xuat: ");
                    String publishYear = scanner.nextLine();

                    System.out.print("Gia: ");
                    String price = scanner.nextLine();
                    
                    System.out.print("Mau xe: ");
                    String color = scanner.nextLine();
                    
                    System.out.print("Kieuxe(Oto/Xemay/XeTai): ");
                    String kieuxe = scanner.nextLine();

                    Car newCar;
                    switch (kieuxe.toLowerCase()) {
                        case "oto":
                            System.out.print("So cho ngoi: ");
                            int slots = scanner.nextInt();
                            scanner.nextLine(); // Clear the buffer

                            System.out.print("Kieu dong co: ");
                            String engineType = scanner.nextLine();

                            newCar = new Oto(id, name, brand, publishYear, price, color, slots, engineType);
                            break;
                        case "xemay":
                            System.out.println("Cong Suat: ");
                            String capacity = scanner.nextLine();

                            newCar = new Xemay(id, name, brand, publishYear, price, color, capacity);
                            break;
                        case "xetai":
                            System.out.print("Trong Tai: ");
                            String loadWeight = scanner.nextLine();

                            newCar = new XeTai(id, name, brand, publishYear, price, color, loadWeight);
                            break;
                        default:
                            System.out.println("Invalid Car Type!");
                            continue; // Go back to the main menu
                    }

                    // Add the new employee to the list
                    quanlyXe.addCar(newCar);
                    System.out.println("Added new car successfully!");
                    break;
                case 2:
                    System.out.println("Danh sach phuong tien xe:");
                    quanlyXe.displayAllCar();
                    break;
                case 3:
                    System.out.print("Nhap ID phuong tien xe can tim: ");
                    int searchId = scanner.nextInt();
                    Car foundCar = quanlyXe.findCarById(searchId);
                    if (foundCar != null) {
                        System.out.println("Xe co ID " + searchId + ":");
                        foundCar.showInfo();
                    } else {
                        System.out.println("Khong tim thay xe co ID " + searchId);
                    }
                    break;
                
                case 4:
                    System.out.print("Nhap ID xe can xoa: ");
                    int deleteId = scanner.nextInt();
                    quanlyXe.deleteCar(deleteId);
                    System.out.println("Da xoa phuong tien xe co ID " + deleteId);
                    break;
                 case 5:
                    System.out.print("Nhap ten file de ghi danh sach phuong tien xe: ");
                    String ghiFile = scanner.next();
                    try {
                        FileOutputStream fos = new FileOutputStream(ghiFile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(quanlyXe.getCars());
                        oos.close();
                        fos.close();
                        System.out.println("Danh sach phuong tien xe da duoc ghi vao file '" + ghiFile + "'.");
                    } catch (IOException e) {
                        System.out.println("Loi khi ghi file: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Nhap ten file de doc danh sach phuong tien xe: ");
                    String docFile = scanner.next();
                    try {
                        FileInputStream fis = new FileInputStream(docFile);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        List<Car> loadedCars = (List<Car>) ois.readObject();
                        quanlyXe.setCars(loadedCars);
                        ois.close();
                        fis.close();
                        System.out.println("Danh sach phuong tien xe da duoc doc tu file '" + docFile + "'.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Loi khi doc file: " + e.getMessage());
                    }
                    break;                           
                case 7:
                    System.out.println("BYE!");
                    stop=false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai.");
                    break;
            }
        } while(stop);
      
        scanner.close();
    }
}