package game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String NPC_ID = "karczmarz";

    private final NpcRepository npcRepository;
    private Npc npc;
    private Node actualNode;

    public Game(NpcRepository npcRepository) {
        this.npcRepository = npcRepository;
        npc = npcRepository.getNpcById(NPC_ID);
        actualNode = npc.getFirstNode();
    }

     public List<String> getDialogs() {
         return actualNode.getDialogs().stream()
                 .map(Dialog::getText)
                 .toList();
    }

    public DialogResult selectOption(int answerIndex) {
        List<Dialog> dialogs = actualNode.getDialogs();
        Dialog dialog = dialogs.get(answerIndex);
        String response = dialog.getResponse();
        if (dialog.getChangeNode() != null) {
            actualNode = dialog.getChangeNode();
        }
        List<String> systemMessages = new ArrayList<>();
        return new DialogResult("Gracz",dialog.getText(),NPC_ID,response,
                systemMessages);
    }
}
