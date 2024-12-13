package shoppingCart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoppingCart {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    void sortProductsByPrice() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
    }

    void sortProductsByPriceReversed() {
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
    }

    public Product getCheapestProduct() {
        return this.products.stream().min(Comparator.comparing(Product::getPrice)).orElse(null);
    }

    public Product getMostExpensiveProduct() {
        return this.products.stream().max(Comparator.comparing(Product::getPrice)).orElse(null);
    }

    double getTotalDiscountPrice() {
        return products.stream().mapToDouble(product -> product.discountPrice).sum();
    }

    public void sortProductsByPriceAndName() {
        this.products.sort(Comparator.comparing(Product::getPrice).thenComparing(Product::getName));
    }
}
