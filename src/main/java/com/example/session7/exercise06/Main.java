package com.example.session7.exercise06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CategoryManager manager = new CategoryManager();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- QUẢN LÝ DANH MỤC ---");
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng (1-6): ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Nhập ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Nhập Tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập Mô tả: ");
                        String desc = scanner.nextLine();
                        manager.addCategory(new Category(id, name, desc));
                        break;
                    case "2":
                        manager.displayAll();
                        break;
                    case "3":
                        System.out.print("Nhập ID danh mục cần cập nhật: ");
                        String updateId = scanner.nextLine();
                        System.out.print("Nhập Tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nhập Mô tả mới: ");
                        String newDesc = scanner.nextLine();
                        manager.updateCategory(updateId, newName, newDesc);
                        break;
                    case "4":
                        System.out.print("Nhập ID danh mục cần xóa: ");
                        String deleteId = scanner.nextLine();
                        manager.deleteCategory(deleteId);
                        break;
                    case "5":
                        System.out.print("Nhập tên cần tìm: ");
                        String keyword = scanner.nextLine();
                        manager.searchByName(keyword);
                        break;
                    case "6":
                        isRunning = false;
                        System.out.println("Đã thoát chương trình.");
                        break;
                    default:
                        System.out.println("[Lỗi] Chức năng không hợp lệ. Vui lòng chọn lại.");
                }
            } catch (Exception e) {
                // Xử lý ngoại lệ cơ bản (Phòng hờ)
                System.out.println("[Lỗi hệ thống] " + e.getMessage());
            }
        }
        scanner.close();
    }
}
