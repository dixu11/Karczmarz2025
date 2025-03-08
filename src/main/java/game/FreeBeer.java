package game;

public class FreeBeer extends Beer {
    @Override
    int getCost() {
        return 0;
    }

    @Override
    public ItemType getType() {
        return ItemType.FREE_BEER;
    }
}
