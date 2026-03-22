package com.example.session7.exercise06;

import java.util.*;
import java.util.stream.Collectors;

public class CategoryManager {
    private final List<Category> categories = new ArrayList<>();

    public void addCategory(Category category) {
        // Validation cơ bản: Không cho phép trùng ID
        if (findById(category.getId()).isPresent()) {
            System.out.println("[Lỗi] ID danh mục đã tồn tại!");
            return;
        }
        categories.add(category);
        System.out.println("[Thành công] Đã thêm danh mục.");
    }

    public void displayAll() {
        if (categories.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        // Dùng method reference (tương tự truyền callback function trong JS)
        categories.forEach(System.out::println);
    }

    public void updateCategory(String id, String newName, String newDescription) {
        // Dùng Optional để xử lý trường hợp không tìm thấy (tránh NullPointerException)
        Optional<Category> categoryOpt = findById(id);
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            category.setName(newName);
            category.setDescription(newDescription);
            System.out.println("[Thành công] Đã cập nhật danh mục.");
        } else {
            System.out.println("[Lỗi] Không tìm thấy danh mục với ID: " + id);
        }
    }

    public void deleteCategory(String id) {
        // removeIf: Trả về true nếu có phần tử bị xóa. Cách tiếp cận Functional.
        boolean isRemoved = categories.removeIf(category -> category.getId().equals(id));
        if (isRemoved) {
            System.out.println("[Thành công] Đã xóa danh mục.");
        } else {
            System.out.println("[Lỗi] Không tìm thấy danh mục với ID: " + id);
        }
    }

    public void searchByName(String nameKeyword) {
        // Dùng Java Stream API (Giống cách dùng .filter() của Array trong JS)
        List<Category> results = categories.stream()
                .filter(category -> category.getName().toLowerCase().contains(nameKeyword.toLowerCase()))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("Không tìm thấy danh mục nào khớp với từ khóa: " + nameKeyword);
        } else {
            results.forEach(System.out::println);
        }
    }

    // Tìm kiếm theo ID
    private Optional<Category> findById(String id) {
        return categories.stream()
                .filter(category -> category.getId().equals(id))
                .findFirst();
    }
}
