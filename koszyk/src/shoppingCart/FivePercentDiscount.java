package shoppingCart;

public class FivePercentDiscount extends Promotion {
    private  double percentage = 0.05;

    public FivePercentDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    boolean canExecute(ShoppingCart cart) {
        return cart.getTotalPrice() > 300;
    }

    @Override
    void execute(ShoppingCart cart) {
        if (canExecute(cart)) {
            for (Product product : cart.products) {
                product.discountPrice *= (1 - percentage);
            }
        }
    }
}