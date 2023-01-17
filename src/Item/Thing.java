package Item;

public interface Thing {
    String name();
    Integer amount();
    Integer price();

    String description();

    void decreaseAmount(int numberToDecrease);
    void increaseAmount(int numberToIncrease);
}
