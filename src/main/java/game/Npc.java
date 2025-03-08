package game;

import java.util.List;

public class Npc {
    private String id;
    private String greeting;
    private List<Dialog> dialogs;
    private List<Node> nodes;

    public Npc(String id, String greeting, List<Dialog> dialogs, List<Node> nodes) {
        this.id = id;
        this.greeting = greeting;
        this.dialogs = dialogs;
        this.nodes = nodes;
    }

    public Node getFirstNode() {
        return nodes.getFirst();
    }

    public String getGreeting() {
        return greeting;
    }
}
