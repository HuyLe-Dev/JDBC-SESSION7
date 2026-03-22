package com.example.session7.exercise08;

import java.util.Scanner;

// 1. ENUM: Định nghĩa kiểu dữ liệu Giới tính
enum Gender {
    MALE, FEMALE, OTHER
}

public class Student {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String phoneNumber;

    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Student() {
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập ID: ");
        this.id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập giới tính (1: Nam, 2: Nữ, Khác: Other):");
        String genderInput = scanner.nextLine();
        switch (genderInput) {
            case "1":
                this.gender = Gender.MALE;
                break;
            case "2":
                this.gender = Gender.FEMALE;
                break;
            default:
                this.gender = Gender.OTHER;
        }

        System.out.print("Nhập địa chỉ: ");
        this.address = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        this.phoneNumber = scanner.nextLine();
    }

    public void displayData() {
        System.out.printf("ID: %-5d | Tên: %-15s | Tuổi: %-3d | Giới tính: %-7s | SĐT: %-12s | Địa chỉ: %s%n",
                id, name, age, gender, phoneNumber, address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
