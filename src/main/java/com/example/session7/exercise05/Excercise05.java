package com.example.session7.exercise05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Excercise05 {
    private static final Scanner sc = new Scanner(System.in);
    private static final ProductManager manager = new ProductManager();

    public static void main(String[] args) {
        System.out.println("HELLO WORLD!");

        boolean isRunning = true;

        while (isRunning) {
            printMenu();

            var choice = sc.nextLine();
            // Sử dụng Switch Expression (Java 14+) - Không cần break, trả về/thực thi trực
            // tiếp
            switch (choice) {
                case "1" -> handleAddProduct();
                case "2" -> manager.displayAll();
                case "3" -> handleUpdateProduct();
                case "4" -> handleDeleteProduct();
                case "5" -> {
                    System.out.println("Dang thoat chuong trinh ...");
                    isRunning = false;
                }

                default -> System.out.println("Nhap sai! Vui long nhap lai!");
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n--- QUẢN LÝ SẢN PHẨM ---");
        System.out.println("1. Thêm mới sản phẩm");
        System.out.println("2. Hiển thị danh sách");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private static void handleAddProduct() {
        System.out.print("Nhap Id: ");
        var id = sc.nextLine();
        System.out.print("Nhap ten: ");
        var name = sc.nextLine();
        System.out.print("Nhap gia: ");
        var price = Double.parseDouble(sc.nextLine());

        manager.addProduct(new Product(id, name, price));
        System.out.println("Them thanh cong!");
    }

    private static void handleUpdateProduct() {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        var id = sc.nextLine();

        System.out.print("Nhap ten moi: ");
        var newName = sc.nextLine();
        System.out.print("Nhap gia moi: ");
        var newPrice = Double.parseDouble(sc.nextLine());

        if (manager.updateProduct(id, newName, newPrice)) {
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("Khong tim thay san pham voi ID: " + id);
        }
    }

    private static void handleDeleteProduct() {
        System.out.print("Nhap Id can xoa: ");
        var id = sc.nextLine();

        if (manager.deleteProduct(id)) {
            System.out.println("Xoa thanh cong");
        } else {
            System.out.println("Khong tim thay san pham!");
        }
    }
}
