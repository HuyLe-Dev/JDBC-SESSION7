package main.java.com.example.session7.exercise05;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductManager {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayAll() {
        if (products.isEmpty()) {
            System.out.println("Danh sach trong!");
            return;
        }
        // Sử dụng method reference, tương đương products.forEach(p => console.log(p))
        // trong TS
        products.forEach(System.out::println);
    }

    public Optional<Product> findById(String id) {
        // Sử dụng Stream API tương đương mảng.find() trong JS
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public boolean updateProduct(String id, String newName, double newPrice) {
        var productOpt = findById(id);
        if (productOpt.isPresent()) {
            var product = productOpt.get();
            product.setName(newName);
            product.setPrice(newPrice);
            return true;
        }
        return false;
    }

    public boolean deleteProduct(String id) {
        // Tương đương products.filter(p => p.id !== id) nhưng modify trực tiếp list
        // (mutable)
        return products.removeIf(p -> p.getId().equals(id));
    }
}
