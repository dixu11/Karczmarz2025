package game;

import java.util.List;

public class Npc {
    private String id;
    private List<Dialog> dialogs;
    private List<Node> nodes;

    public Npc(String id, List<Dialog> dialogs, List<Node> nodes) {
        this.id = id;
        this.dialogs = dialogs;
        this.nodes = nodes;
    }

    public Node getFirstNode() {
        return nodes.getFirst();
    }
}
