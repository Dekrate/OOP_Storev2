package Item;

public class Paper implements Thing {
    private final String name;
    private Integer amount;
    private final Integer price;
    private final String description;

    public Paper(String name, Integer amount, Integer price, String description) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.description = description;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Integer amount() {
        return amount;
    }

    @Override
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
