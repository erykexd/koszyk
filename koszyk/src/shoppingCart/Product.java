package shoppingCart;

public class Product implements Comparable<Product> {
    String code;
    String name;
    double price;
    double discountPrice;

    public Product(String code, String name, double price) {
        if (code == null || name == null) {
            throw new IllegalArgumentException("Code/Name cannot be null");
        }
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Product other) {
        int priceComparison = Double.compare(price, other.price);

        if (priceComparison == 0) {
            return name.compareTo(other.name);
        } else {
            return priceComparison;
        }
    }
}
