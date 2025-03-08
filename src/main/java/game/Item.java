package game;

public abstract class Item {
    abstract int getCost();

    abstract String getName();

    abstract String specialMessage();

    String buyMessage() {
        return "Kupiłeś " + getName() + ".";
    }

    String cannotAffordMessage() {
        return "Nie stać Cię!";
    }

    public abstract ItemType getType();
}
