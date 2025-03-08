package game;

public class ItemFactory {

    public Item getItemByType(ItemType buyItemType) {
       return switch (buyItemType){
            case BEER -> new Beer();
            case FOOD -> new Food();
            case ROOM -> new Room();
           case FREE_BEER -> new FreeBeer();
       };
    }
}
