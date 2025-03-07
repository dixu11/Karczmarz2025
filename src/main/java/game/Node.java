package game;

import java.util.List;

public class Node {
    private List<Dialog> dialogs;

    public Node(List<Dialog> dialogs) {
        this.dialogs = dialogs;
    }

    public List<Dialog> getDialogs() {
        return dialogs;
    }
}
