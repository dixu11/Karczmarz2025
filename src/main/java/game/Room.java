package game;

public class Room extends Item{
    @Override
    int getCost() {
        return 5;
    }

    @Override
    String getName() {
        return "pokój";
    }

    @Override
    String specialMessage() {
        return "Masz sen - Jesteś na statku, widzisz przed sobą wielką osmiornicę. Uciekasz pod pokład?";
    }
}
