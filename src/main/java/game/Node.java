package game;

import java.util.List;

public class Node {
    private int id;
    private List<Dialog> dialogs;

    public Node(int id, List<Dialog> dialogs) {
        this.id = id;
        this.dialogs = dialogs;
    }

    public List<Dialog> getDialogs() {
        return dialogs;
    }

    public int getId() {
        return id;
    }

    public boolean hasPaidOption() {
        return dialogs.stream()
                .anyMatch(Dialog::hasBuyItem);

    }
}
