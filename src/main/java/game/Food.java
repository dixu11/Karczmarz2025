package game;

public class Food extends Item{
    @Override
    int getCost() {
        return 4;
    }

    @Override
    String getName() {
        return "obiad";
    }

    @Override
    String specialMessage() {
        return "Dzisiaj schabowe. Smakują wybornie!";
    }

    @Override
    public ItemType getType() {
        return ItemType.FOOD;
    }
}
