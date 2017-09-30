package hautelook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bill on 4/10/17.
 */
public class Cart {

    private final List<Item> items = new ArrayList<>();


    public double subtotal() {
        double subtotal = 0.0;
        for(Item item: items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    public void addItem(String name, double price, double weight) {
        items.add(new Item(name, price, weight));
    }

    public List<Item> getItems() {
        return items;
    }
}
