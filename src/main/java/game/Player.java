package game;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    private int money = 10;

    private Map<ItemType, AtomicInteger> items = new HashMap<>();

    public Player() {
        Arrays.stream(ItemType.values())
                .forEach(type -> items.put(type, new AtomicInteger()));
    }

    public int getMoney() {
        return money;
    }

    public void pay(int cost,ItemType forItem) {
        money -= cost;
        items.get(forItem).incrementAndGet();
    }

    public Map<ItemType, AtomicInteger> getItems() {
        return items;
    }
}
