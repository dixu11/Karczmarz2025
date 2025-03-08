package game;

public class Beer extends Item{
    @Override
    int getCost() {
        return 3;
    }

    @Override
    String getName() {
        return "Piwo";
    }

    @Override
    String specialMessage() {
        return "Kręci Ci się w glowie ale trunek smakuje całkiem niezle. To był dobry wybór!";
    }

    @Override
    public ItemType getType() {
        return ItemType.BEER;
    }
}
