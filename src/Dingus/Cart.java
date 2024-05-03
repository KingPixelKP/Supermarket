package Dingus;

import Dingus.Exceptions.EmptyCartException;
import Dingus.Exceptions.FullCartException;
import Dingus.Exceptions.NoItemException;

import java.util.Iterator;

public interface Cart {
    Iterator<Item> iterator() throws EmptyCartException;
    void add(Item item) throws FullCartException;
    void remove(Item item) throws NoItemException;
    boolean equals(Object obj);
}
