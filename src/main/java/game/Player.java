package game;

public class Player {
    private int money = 10;

    public int getMoney() {
        return money;
    }

    public void pay(int cost) {
        money -= cost;
    }
}
