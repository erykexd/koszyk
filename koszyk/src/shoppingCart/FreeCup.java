package shoppingCart;

public class FreeCup extends Promotion {
    private final Product gift;

    public FreeCup(Product gift) {
        this.gift = gift;
    }

    @Override
    public boolean canExecute(ShoppingCart cart) {
        return cart.getTotalPrice() > 200;
    }

    @Override
    public void execute(ShoppingCart cart) {
        cart.addProduct(gift);
    }
}