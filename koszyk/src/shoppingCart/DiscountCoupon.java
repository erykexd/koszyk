package shoppingCart;

public class DiscountCoupon extends Promotion {
    private String couponCode;
    private double discount = 0.3;

    public DiscountCoupon(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public boolean canExecute(ShoppingCart cart) {
        return cart.products.stream().anyMatch(product -> product.code.equals(couponCode));
    }

    @Override
    void execute(ShoppingCart cart) {
        for (Product product : cart.products) {
            if (product.code.equals(couponCode)) {
                product.discountPrice *= (1 - discount);
            }
        }
    }
}
