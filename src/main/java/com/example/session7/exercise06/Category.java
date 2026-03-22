package com.example.session7.exercise06;

public class Category {
    private String id;
    private String name;
    private String description;

    // Constructor: Hàm khởi tạo
    public Category(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return String.format("ID: %-5s | Tên: %-15s | Mô tả: %s", id, name, description);
    }
}
