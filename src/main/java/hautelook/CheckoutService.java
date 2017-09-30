package hautelook;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.util.List;

public class CheckoutService {

    private Cart cart;
    private Discount discount;

    public CheckoutService() {
        this.cart = new Cart();
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getSubtotal() {

        final double itemTotal = cart.subtotal();
        double discountAmount = 0.0;

        if(discount != null) {
            discountAmount = itemTotal * -(discount.getPercent() / 100.0);
        }

        return itemTotal + discountAmount;
    }

    public void addItemToCart(String name, double price) {
        cart.addItem(name, price);
    }

    public void addItemToCart(String name, double price, double weight) {
        cart.addItem(name, price, weight);
    }

    public List<Item> searchCartByName(final String name) {

        return  searchCart(
                new Predicate<Item>() {
                    @Override
                    public boolean evaluate(Item item) {
                        return item.getName().equals(name);
                    }
                });
    }

    public List<Item> searchCart(Predicate<Item> query) {
        return (List<Item>) CollectionUtils.select(cart.getItems(), query);
    }

    public double getShippingCost() {
        double perItemShippingCost = 0.0;
        int numUnder10lbs = 0;
        int numOver10lbs = 0;
        List<Item> items = cart.getItems();
        for(Item item: items) {
            Double weight = item.getWeight();
            if (weight == null || weight == Double.NaN) {
                throw new IllegalArgumentException("no weight specified for item " + item.getName());
            }
            if (item.getWeight() >= 10.0) {
                perItemShippingCost += 20.0;
                numOver10lbs++;
            } else {
                numUnder10lbs++;
            }
        }

        double subTotal = getSubtotal();
        int numItems = items.size();

        if(subTotal<100.0 && numUnder10lbs == numItems) {
            return 5.0;
        }

        if(subTotal>=100.0 && numUnder10lbs == numItems) {
            return 0.0;
        }

        if (numOver10lbs < numItems && subTotal<100) {
            return perItemShippingCost + 5.0;
        }

        return perItemShippingCost;

    }

    public double getTotalWithShippingCost() {
        return getSubtotal() + getShippingCost();
    }
}
