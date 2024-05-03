package Dingus;

import Dingus.Exceptions.*;

import java.util.Iterator;

public interface CartManager {
    void addCart(String ID, int volume) throws ExistingCartException;
    void addItem(String itemName, int price, int volume) throws ExistingItemException;
    void addToCart(String itemName, String cartId) throws ExistingItemException, ExistingCartException, FullCartException;
    void removeItem(String cartId, String itemName) throws ExistingCartException, NoItemException;
    Iterator<Item> listItems(String cartId) throws ExistingCartException, EmptyCartException;
    int pay(String cartId) throws ExistingCartException, EmptyCartException;
}
