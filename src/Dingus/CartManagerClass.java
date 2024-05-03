package Dingus;

import Dingus.Exceptions.*;

import java.util.*;

public class CartManagerClass implements CartManager {

    List<Cart> carts;
    Map<String, Item> itemMap;

    public CartManagerClass() {
        this.carts = new ArrayList<>();
        this.itemMap = new HashMap<>();
    }

    @Override
    public void addCart(String ID, int volume) throws ExistingCartException {
        if (carts.contains(new CartClass(ID, volume))) {
            throw new ExistingCartException("Cart already exists");
        }
        this.carts.add(new CartClass(ID, volume));
    }

    @Override
    public void addItem(String itemName, int price, int volume) throws ExistingItemException {
        if (itemMap.containsKey(itemName)) {
            throw new ExistingItemException("Item already exists");
        }
        this.itemMap.put(itemName, new ItemClass(itemName, price, volume));
    }

    @Override
    public void addToCart(String itemName, String cartId) throws ExistingItemException, ExistingCartException, FullCartException {
        if (!carts.contains(new CartClass(cartId,0))) {
            throw new ExistingCartException("Cart does not exist");
        }
        if (!this.itemMap.containsKey(itemName)) {
            throw new ExistingItemException("Item does not exist");
        }
        carts.get(carts.indexOf(new CartClass(cartId,0))).add(itemMap.get(itemName));
    }

    @Override
    public void removeItem(String cartId, String itemName) throws ExistingCartException, NoItemException {
        if (!carts.contains(new CartClass(cartId,0))) {
            throw new ExistingCartException("Cart does not exist");
        }
        carts.get(carts.indexOf(new CartClass(cartId,0))).remove(itemMap.get(itemName));
    }

    @Override
    public Iterator<Item> listItems(String cartId) throws ExistingCartException, EmptyCartException {
        if (!carts.contains(new CartClass(cartId,0))) {
            throw new ExistingCartException("Cart does not exist");
        }
        return carts.get(carts.indexOf(new CartClass(cartId,0))).iterator();
    }

    @Override
    public int pay(String cartId) throws ExistingCartException, EmptyCartException {
        if (!carts.contains(new CartClass(cartId,0))) {
            throw new ExistingCartException("Cart does not exist");
        }
        Iterator<Item> it = carts.get(carts.indexOf(new CartClass(cartId,0))).iterator(); //Throws exception car does not have items
        int price = 0;
        while (it.hasNext()) {
            price += it.next().getPrice();
        }
        return price;
    }
}
