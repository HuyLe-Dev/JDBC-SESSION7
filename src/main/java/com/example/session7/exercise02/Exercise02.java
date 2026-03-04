package main.java.com.example.session7.exercise02;

public class Exercise02 {
    public static void main(String[] args) {
        Book book = new Book();

        book.setTitle("Java 入門");
        book.setAuthor("フイ");
        book.setPrice(3333);

        System.out.println("title: " + book.getTitle());
        System.out.println("author: " + book.getAuthor());
        System.out.println("price: " + book.getPrice());

        book.setPrice(9999);
        System.out.println("New Price: " + book.getPrice());
        book.setPrice(-123);
    }
}
