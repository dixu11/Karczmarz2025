package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
        List<String> dialogs = actualNode.getVisibleDialogs().stream()
                .map(Dialog::getText)
                .toList();
        if (actualNode.hasPaidOption()) {
            systemMessages.add("Posiadane monety: " + player.getMoney());
        }
        return new DialogOptions(dialogs,systemMessages);
    }


    public DialogResult selectOption(int answerIndex) { //todo refactor decompose
        List<Dialog> dialogs = actualNode.getVisibleDialogs();
        Dialog dialog = dialogs.get(answerIndex);
        updateDialogsCounters(dialogs, dialog);
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
            player.pay(item.getCost(),item.getType());
            systemMessages.add(item.specialMessage());
        }
        if (dialog.endsGame()) {
            dialogResult.setGameOver(true);
        }
        if (dialog.hasChangeNode()) {
            actualNode = dialog.getChangeNode();
        }
        return dialogResult;
    }

    private void updateDialogsCounters(List<Dialog> seenDialogs, Dialog selected) {
        selected.selected();
        seenDialogs.forEach(Dialog::seen);
    }

    public Map<ItemType,AtomicInteger> getStats() {
        return player.getItems();
    }
}
