package Item;

public class Chocolate implements Thing {

    private final String name;
    private int amount;
    private final int price;
    private final String description;

    public Chocolate(String name, int amount, int price, String description) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.description = description;
    }

    @Override
    public String name() {
        return name;
    }

    public Integer amount() {
        return amount;
    }

    public Integer price() {
        return price;
    }
    @Override
    public String description() {
        return description;
    }

    @Override
    public void decreaseAmount(int numberToDecrease) {
        amount = amount - numberToDecrease;
    }

    @Override
    public void increaseAmount(int numberToIncrease) {
        amount = amount + numberToIncrease;
    }

    @Override
    public String toString() {
        return name + ", Amount: " + amount + ", Price: " + price + ", Description " + description;
    }
}
