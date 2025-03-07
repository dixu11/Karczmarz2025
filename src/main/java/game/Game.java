package game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String NPC_ID = "Karczmarz";

    private final NpcRepository npcRepository;
    private Npc npc;
    private Node actualNode;
    private Player player = new Player();

    public Game(NpcRepository npcRepository) {
        this.npcRepository = npcRepository;
        npc = npcRepository.getNpcById(NPC_ID);
        actualNode = npc.getFirstNode();
    }

    public DialogOptions getDialogs() {
        List<String> systemMessages = new ArrayList<>();
        List<String> dialogs = actualNode.getDialogs().stream()
                .map(Dialog::getText)
                .toList();
        if (actualNode.hasPaidOption()) {
            systemMessages.add("Posiadane monety: " + player.getMoney());
        }

        return new DialogOptions(dialogs,systemMessages);
    }


    public DialogResult selectOption(int answerIndex) { //todo refactor decompose
        List<Dialog> dialogs = actualNode.getDialogs();
        Dialog dialog = dialogs.get(answerIndex);
        String response = dialog.getResponse();
        List<String> systemMessages = new ArrayList<>();
        DialogResult dialogResult = new DialogResult("Gracz", dialog.getText(), NPC_ID, response,
                systemMessages);
        if (dialog.hasBuyItem()) {
            Item item = dialog.getBuyItem();
            if (item.getCost() > player.getMoney()) {
                systemMessages.add(item.cannotAffordMessage());
                return dialogResult;
            }
            player.pay(item.getCost());
            systemMessages.add(item.specialMessage());
        }
        if (dialog.hasChangeNode()) {
            actualNode = dialog.getChangeNode();
        }
        return dialogResult;
    }
}
