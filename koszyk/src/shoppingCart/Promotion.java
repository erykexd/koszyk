package shoppingCart;

import java.util.Collection;

public abstract class Promotion {
    abstract boolean canExecute(ShoppingCart cart);
    abstract void execute(ShoppingCart cart);
}