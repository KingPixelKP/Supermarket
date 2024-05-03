package Dingus;

import Dingus.Exceptions.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CartClass implements Cart{

    ArrayList<Item> items;
    int volume;
    int volumeUsed;
    String id;


    public CartClass(String id, int volume){
        this.id=id;
        this.volume=volume;
        this.volumeUsed=0;
        items=new ArrayList<>();
    }

    @Override
    public Iterator<Item> iterator() throws EmptyCartException {
        if (items.isEmpty()){
            throw new EmptyCartException("Cart is empty");
        }
        return items.iterator();
    }

    @Override
    public void add(Item item) throws FullCartException{
        if (!canAdd(item))
            throw new FullCartException("Cannot add item to the cart");
        items.add(item);
        volumeUsed += item.getVolume();
    }

    @Override
    public void remove(Item item) throws NoItemException{
        if (!items.contains(item))
            throw new NoItemException("Car does not have item");
        items.remove(item);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CartClass otherCart){
            return this.id.equals(otherCart.id);
        }
        return false;
    }

    private boolean canAdd(Item item) {
        return volumeUsed + item.getVolume() >= this.volume;
    }
}
