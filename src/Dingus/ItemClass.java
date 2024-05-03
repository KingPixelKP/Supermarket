package Dingus;

public class ItemClass implements Item{

    private int price;
    private int volume;
    String itemName;

    public ItemClass(String itemName, int price, int volume){
        this.itemName = itemName;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public String getName() {
        return this.itemName;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }
}
