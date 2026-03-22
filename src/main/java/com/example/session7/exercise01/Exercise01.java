package com.example.session7.exercise01;

public class Exercise01 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Rectangle rectangle = new Rectangle();

        System.out.println("Rectangle 1:");
        rectangle.display();

        Rectangle rectangle2 = new Rectangle(5.0, 3.0);
        System.out.println("\nRectangle 2:");
        rectangle2.display();

    }
}