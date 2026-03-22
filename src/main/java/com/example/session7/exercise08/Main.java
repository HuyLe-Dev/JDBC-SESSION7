package com.example.session7.exercise08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n=== Quản lý sinh viên ===");
            System.out.println("1. Hiển thị tất cả sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manager.displayAll();
                    break;
                case 2:
                    manager.addStudent(scanner);
                    break;
                case 3:
                    manager.updateStudent(scanner);
                    break;
                case 4:
                    manager.deleteStudent(scanner);
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
        scanner.close();
    }
}
