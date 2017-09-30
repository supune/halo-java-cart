package hautelook;


public class Item {

    private final String name;
    private final double price;
    private final Double weight;

    public Item(String name, double price, Double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Item(String name, double price) {
        this(name, price, Double.NaN);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Double getWeight() {
        return weight;
    }
}
