import Item.Chocolate;
import Item.Jam;
import Item.Paper;
import Item.Thing;

import java.util.ArrayList;

public class Client {
    private final int money;
    private ArrayList<Thing> basket = new ArrayList<>();

    public Client(int money) {
        this.money = money;
    }

    public int money() {
        return money;
    }

    boolean ifItemExist(Thing item) {
        for (Thing thing : basket) {
            if (thing.name().equals(item.name())) {
                return true;
            }
        }
        return false;
    }

    public void addToBasket(Thing thing, Integer amount) throws ArithmeticException {
        if (thing.amount() - amount >= 0) {
            if (ifItemExist(thing)) {
                for (Thing item : basket) {
                    if (thing.name().equals(item.name())) {
                        item.increaseAmount(amount);
                    }
                }
            } else {
                if (thing instanceof Chocolate) {
                    basket.add(new Chocolate(thing.name(), amount, thing.price(), thing.description()));
                } else if (thing instanceof Jam) {
                    basket.add(new Jam(thing.name(), amount, thing.price(), thing.description()));
                } else if (thing instanceof Paper) {
                    basket.add(new Paper(thing.name(), amount, thing.price(), thing.description()));
                }
            }
            thing.decreaseAmount(amount);
        } else {
            throw new ArithmeticException("There is not to many items available! You go out!");
        }
    }

    public void removeFromBasket(Thing thing, Shop shop) {
        shop.itemsInShop();
        for (Thing items : shop.itemsInShop()) {
            if (items.name().equals(thing.name())) {
                items.increaseAmount(thing.amount());
            }
        }
        basket.remove(thing);
    }
    public void showBasket() {
        for (int i = 0; i < basket.size(); i++) {
            Thing thing = basket.get(i);
            System.out.println(i + ". " + thing);
        }
    }


    public ArrayList<Thing> basket() {
        return basket;
    }

    public void pay() {
        int sum = 0;
        for (Thing thing : basket) {
            sum+= thing.price()*thing.amount();
        }
        if (sum > money) {
            throw new ArithmeticException("You don't have enough money to pay!");
        } else {
            System.out.println("You pay " +  sum + ". Your money after this transaction is: " + (money - sum));
        }
    }
}
