package com.example.session7.exercise08;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("Không có sinh viên nào để hiển thị.");
            return;
        }
        students.forEach(Student::displayData);
    }

    public void addStudent(Scanner scanner) {
        Student student = new Student();
        student.inputData(scanner);

        if (findById(student.getId()).isPresent()) {
            System.out.println("Sinh viên với ID đã tồn tại.");
        } else {
            students.add(student);
            System.out.println("Thêm sinh viên thành công.");
        }
    }

    public void updateStudent(Scanner scanner) {
        System.out.println("Nhập ID của sinh viên cần cập nhật:");
        int id = Integer.parseInt(scanner.nextLine());

        Optional<Student> studentOpt = findById(id);

        if (studentOpt.isPresent()) {
            System.out.println("Cập nhật thông tin cho sinh viên ID: " + id);
            Student student = studentOpt.get();

            int oldId = student.getId();
            student.inputData(scanner);
            student.setId(oldId);

            System.out.println("Cập nhật sinh viên thành công.");
        } else {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
        }
    }

    public void deleteStudent(Scanner scanner) {
        System.out.println("Nhập ID của sinh viên cần xóa:");
        int id = Integer.parseInt(scanner.nextLine());

        boolean isRemoved = students.removeIf(s -> s.getId() == id);
        if (isRemoved) {
            System.out.println("Xóa sinh viên thành công.");
        } else {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
        }

    }

    public Optional<Student> findById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }
}
