package shoppingCart;

import java.util.Collections;
import java.util.Comparator;

public class CheapestForFree extends Promotion {
    @Override
    public boolean canExecute(ShoppingCart cart) {
        return !cart.products.isEmpty() && cart.products.size() >= 3;
    }

    @Override
    public void execute(ShoppingCart cart) {
        if (canExecute(cart)) {
            Product cheapestProduct = Collections.min(cart.products, Comparator.comparingDouble(Product::getPrice));
            cheapestProduct.discountPrice = 0;
        }
    }
}