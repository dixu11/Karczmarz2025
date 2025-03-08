package game;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static common.JavaUtils.clear;
import static common.JavaUtils.readAnswer;

public class ConsoleController {

   private final Game game;

    public ConsoleController(Game game) {
        this.game = game;
    }

    public void start() {
        System.out.println("Witaj w mojej karczmie! Na co masz ochotę?");
        boolean running = true;
        while(running){
            DialogResult result = executeDialog();
            running = !result.isGameOver();
        }
        System.out.println("Koniec gry!");
        printStats(game.getStats());
    }

    private DialogResult executeDialog() {
        DialogOptions dialogOptions = game.getDialogs();
        showOptions(dialogOptions);
        int answerNr = readAnswer(1,dialogOptions.getDialogs().size());
        clear();
        DialogResult dialogResult = game.selectOption(answerNr - 1);
        printResult(dialogResult);
        return dialogResult;
    }

    private void showOptions(DialogOptions dialogOptions) {
        printSystemMessages(dialogOptions.getSystemMessages());
        List<String> dialogs = dialogOptions.getDialogs();
        printSystemMessage("Wybierz jedną z opcji:");
        System.out.println();
        for (int i = 0; i < dialogs.size(); i++) {
            System.out.printf("%d. %s\n",i+1,dialogs.get(i));
        }
    }

    private void printResult(DialogResult dialogResult) {
        System.out.printf("%s: %s\n",dialogResult.getPlayerName(),dialogResult.getPlayerDialog());
        printSystemMessages(dialogResult.getSystemMessages());
        if (dialogResult.getNpcResponse().isEmpty()) {
            return;
        }
        System.out.println();
        System.out.printf("%s: %s\n",dialogResult.getNpcName(),dialogResult.getNpcResponse());
        System.out.println();
    }

    private void printSystemMessage(String message) {
        System.out.printf("\t#%s\n",message);
    }

    private void printSystemMessages(List<String> systemMessages) {
        for (String systemMessage : systemMessages) {
            printSystemMessage(systemMessage);
            System.out.println();
        }
    }

    private void printStats(Map<ItemType, AtomicInteger> stats){
        System.out.println("Wypite piwa: "+ stats.get(ItemType.BEER));
        System.out.println("Wypite darmowe piwa: " + 0); //todo implement free beer
        System.out.println("Zjedzone schabowe: " + stats.get(ItemType.FOOD));
        System.out.println("Wynajęte pokoje: " + stats.get(ItemType.ROOM));
    }
}
