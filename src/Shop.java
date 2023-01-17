import Item.Chocolate;
import Item.Jam;
import Item.Paper;
import Item.Thing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private ArrayList<Thing> itemsInShop = new ArrayList<>();

    public void initialise() {
        File file = new File("data.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(";");
                switch (line[0]) {
                    case "CHOCOLATE" ->
                            itemsInShop.add(new Chocolate(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), line[4]));
                    case "JAM" ->
                            itemsInShop.add(new Jam(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), line[4]));
                    case "Paper" ->
                            itemsInShop.add(new Paper(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), line[4]));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int priceByIndex(int index) {
        return itemsInShop.get(index).price();
    }

    public void showItemsAvailableInShop() {
        System.out.println("Below you can find items available in our store");
        for (int i = 0; i < itemsInShop.size(); i++) {
            Thing thing = itemsInShop.get(i);
            System.out.println(i + ". " +  thing);
        }
    }

    public ArrayList<Thing> itemsInShop() {
        return itemsInShop;
    }

    public Thing itemById(Integer id) throws IndexOutOfBoundsException {
        if (id >= 0 && id <= itemsInShop.size()) {
            return itemsInShop.get(id);
        } else {
            throw new IndexOutOfBoundsException("We don't have such an item.");
        }
    }
}
