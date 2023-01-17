import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our store!");
        System.out.println("First, declare how much money you have (using comma):");
        Scanner scanner = new Scanner(System.in);
        Client client = null;
        try {
            client = new Client(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.err.println("You entered an invalid value.");
        }
        Shop shop = new Shop();
        shop.initialise();
        System.out.println("1. Test, 2. Program");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                assert 750 == shop.priceByIndex(0);
                assert "English chocolate".equals(shop.itemById(0).name());
            }
            case 2 -> {
                shop.showItemsAvailableInShop();
                System.out.println("Which item would you like to add to the basket? Give a number:");
                int itemToAdd = scanner.nextInt();
                scanner.nextLine();
                System.out.println("How many pieces of this item would you like to add to your basket?");
                int amount = scanner.nextInt();
                scanner.nextLine();
                try {
                    Objects.requireNonNull(client).addToBasket(shop.itemById(itemToAdd), amount);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }
                int shopOption = 0;
                while(shopOption != 3 || shopOption != 4) {
                    shop.showItemsAvailableInShop();
                    System.out.println("1. Add item");
                    System.out.println("2. Remove item");
                    System.out.println("3. Pay");
                    System.out.println("Your items in basket");
                    client.showBasket();
                    shopOption = scanner.nextInt();
                    scanner.nextLine();
                    switch (shopOption) {
                        case 1 -> {
                            System.out.println("Which item would you like to add to the basket? Give a number:");
                            itemToAdd = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("How many pieces of this item would you like to add to your basket?");
                            amount = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                Objects.requireNonNull(client).addToBasket(shop.itemById(itemToAdd), amount);
                            } catch (Exception e) {
                                shopOption = 4;
                                System.err.println(e.getMessage());
                            }
                        }
                        case 2 -> {
                            System.out.println("Which item would you like to remove? Write its id.");
                            int itemIdToRemove = scanner.nextInt();
                            scanner.nextLine();
                            client.removeFromBasket(client.basket().get(itemIdToRemove), shop);
                        }
                        case 3 -> {
                            try {
                                client.pay();
                            } catch (ArithmeticException e) {
                                System.err.println(e.getMessage());
                            }
                            System.exit(0);
                        }

                        default -> throw new IllegalStateException("Unexpected value: " + shopOption);
                    }

                }

            }
        }
    }
}