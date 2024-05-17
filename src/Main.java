import Dingus.CartManager;
import Dingus.CartManagerClass;
import Dingus.Exceptions.*;
import Dingus.Item;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner in = new Scanner(System.in);
        CartManager manager = new CartManagerClass();
        program(manager,in);
    }

    private static void program(CartManager manager, Scanner in) {
        while (true) {
            String command = in.next().toUpperCase();
            if (command.equals("NEW")) {
                command = in.next().toUpperCase();
                if (command.equals("CART")) {
                    addCart(manager, in);
                }

                if (command.equals("ITEM")) {
                    newItem(manager, in);
                }
            }

            if (command.equals("ADD")) {
                addItem(manager,in);
            }

            if (command.equals("REMOVE")) {
                removeItem(manager,in);
            }

            if (command.equals("LIST")) {
                list(manager,in);
            }

            if (command.equals("PAY")) {
                pay(manager,in);
            }
            if (command.equals("EXIT")) {
                break;
            }
        }
    }
    private static void addCart(CartManager manager, Scanner in) {
        try {
            String id = in.next();
            int volume = in.nextInt();
            in.nextLine();
            manager.addCart(id, volume);
            System.out.println("Cart created successfully!");
        } catch (ExistingCartException e) {
            System.out.println("Cart already exist!");
        }
    }

    private static void newItem(CartManager manager, Scanner in) {
        try {
            String itemName = in.next();
            int itemPrice = in.nextInt();
            int itemVolume = in.nextInt();
            in.nextLine();
            manager.addItem(itemName, itemPrice, itemVolume);
            System.out.println("Item created successfully!");
        } catch (ExistingItemException e) {
            System.out.println("Item already exist!");
        }
    }

    private static void addItem(CartManager manager, Scanner in) {
        try {
            String itemName = in.next();
            String cartId = in.next();
            in.nextLine();
            manager.addToCart(itemName, cartId);
            System.out.println("Item added successfully!");
        } catch (ExistingCartException e) {
            System.out.println("Non-existing cart!");
        } catch (ExistingItemException e) {
            System.out.println("Non-existing item!");
        } catch (FullCartException e) {
            System.out.println("Capacity exceeded!");
        }
    }

    private static void removeItem(CartManager manager, Scanner in) {
        try {
            String itemName = in.next();
            String cartId = in.next();
            in.nextLine();
            manager.removeItem(cartId, itemName);
        } catch (ExistingCartException e) {
            System.out.println("Non-existent cart!");
        } catch (NoItemException e) {
            System.out.println("Item is not in cart!");
        }
    }

    private static void list(CartManager manager, Scanner in) {
        try {
            String cartId = in.next();
            in.nextLine();
            Iterator<Item> it = manager.listItems(cartId);
            while (it.hasNext()) {
                Item item = it.next();
                System.out.printf("%s %d\n", item.getName(), item.getPrice());
            }
        } catch (ExistingCartException e) {
            System.out.println("Non-existing cart!");
        } catch (EmptyCartException e) {
            System.out.println("Empty cart!");
        }
    }

    private static void pay(CartManager manager, Scanner in) {
        try {
            String cartId = in.next();
            in.nextLine();
            System.out.println(manager.pay(cartId));
        } catch (ExistingCartException e) {
            System.out.println("Non-existing cart!");
        } catch (EmptyCartException e) {
            System.out.println("Empty cart!");
        }
    }
}