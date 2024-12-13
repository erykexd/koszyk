package shoppingCart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        cart.addProduct(new Product("P1", "Product 1", 50.0));
        cart.addProduct(new Product("P2", "Product 2", 100.0));
        cart.addProduct(new Product("P3", "Product 3", 200.0));
    }

    @Test
    void testGetTotalPrice() {
        assertEquals(350.0, cart.getTotalPrice(), 0.001);
    }

    @Test
    void testSortProductsByPrice() {
        cart.sortProductsByPrice();
        assertEquals("P1", cart.products.get(0).code);
        assertEquals("P2", cart.products.get(1).code);
        assertEquals("P3", cart.products.get(2).code);
    }

    @Test
    void testSortProductsByPriceReversed() {
        cart.sortProductsByPriceReversed();
        assertEquals("P3", cart.products.get(0).code);
        assertEquals("P2", cart.products.get(1).code);
        assertEquals("P1", cart.products.get(2).code);
    }

    @Test
    void testGetCheapestProduct() {
        assertEquals("P1", cart.getCheapestProduct().code);
    }

    @Test
    void testGetMostExpensiveProduct() {
        assertEquals("P3", cart.getMostExpensiveProduct().code);
    }

    @Test
    void testGetTotalDiscountPriceWithFivePercentDiscount() {
        FivePercentDiscount fivePercentDiscount = new FivePercentDiscount(0.05);
        fivePercentDiscount.execute(cart);
        assertEquals(332.5, cart.getTotalDiscountPrice(), 0.001);
    }

    @Test
    void testGetTotalDiscountPriceWithDiscountCoupon() {
        DiscountCoupon discountCoupon = new DiscountCoupon("P3");
        discountCoupon.execute(cart);
        assertEquals(290.0, cart.getTotalDiscountPrice(), 0.001);
    }

    @Test
    void testGetTotalDiscountPriceWithCheapestForFree() {
        CheapestForFree cheapestForFree = new CheapestForFree();
        cheapestForFree.execute(cart);
        assertEquals(300.0, cart.getTotalDiscountPrice(), 0.001);
    }

    @Test
    void testGetTotalDiscountPriceWithFreeCup() {
        // Stan początkowy: koszyk pusty
        assertEquals(3, cart.products.size());

        // Wywołanie promocji FreeCup
        Product cup = new Product("C1", "Cup", 0.0);
        FreeCup freeCup = new FreeCup(cup);
        freeCup.execute(cart);

        // Sprawdzenie, czy kubek został dodany do koszyka
        assertEquals(4, cart.products.size());
        assertTrue(cart.products.contains(cup));

        // Sprawdzenie, czy łączna cena po uwzględnieniu kubka wynosi 350.0
        assertEquals(350.0, cart.getTotalDiscountPrice(), 0.001);
    }


    @Test
    void testSortProductsByPriceAndName() {
        cart.sortProductsByPriceAndName();
        assertEquals("P1", cart.products.get(0).code);
        assertEquals("P2", cart.products.get(1).code);
        assertEquals("P3", cart.products.get(2).code);
    }
}
