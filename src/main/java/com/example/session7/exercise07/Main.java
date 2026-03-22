package com.example.session7.exercise07;

public class Main {
    public static void main(String[] args) {
        try {
            Fraction f1 = new Fraction(1, 2);
            Fraction f2 = new Fraction(3, 4);
            Fraction f3 = new Fraction(10, 5);
            System.out.println("Phân số 1: " + f1);
            System.out.println("Phân số 2: " + f2);
            System.out.println("Phân số 3 (10/5 tự rút gọn): " + f3);

            // Thực hiện phép toán
            System.out.println("\n--- THỰC HIỆN PHÉP TOÁN ---");
            System.out.println(f1 + " + " + f2 + " = " + f1.add(f2)); // 5/4
             System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2)); // 3/8
            System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2)); // 2/3

            // Test ngoại lệ
            System.out.println("\n--- TEST NGOẠI LỆ ---");
            Fraction invalidFraction = new Fraction(5, 0); // Dòng này sẽ throw Exception và nhảy xuống catch
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("LỖI: " + e.getMessage());
        }
    }
}
