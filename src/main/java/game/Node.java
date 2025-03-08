package game;

import java.util.List;

public class Node {
    private int id;
    private List<Dialog> dialogs;

    public Node(int id, List<Dialog> dialogs) {
        this.id = id;
        this.dialogs = dialogs;
    }

    public List<Dialog> getVisibleDialogs() {
        return dialogs.stream()
                .filter(Dialog::isVisible)
                .toList();
    }

    public int getId() {
        return id;
    }

    public boolean hasPaidOption() {
        return dialogs.stream()
                .anyMatch(Dialog::hasBuyItem);

    }
}
