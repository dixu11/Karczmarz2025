package game;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static common.JavaUtils.clear;
import static common.JavaUtils.readAnswer;

public class ConsoleController {

   private final Game game;
    private int dialogsCounter = 0;

    public ConsoleController(Game game) {
        this.game = game;
    }

    public void start() {
        opening();
        printDialogLine(game.getNpcName(),game.getGreeting());
        System.out.println();
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
        dialogsCounter++;
        return dialogResult;
    }

    private void showOptions(DialogOptions dialogOptions) {
        printSystemMessages(dialogOptions.getSystemMessages());
        List<String> dialogs = dialogOptions.getDialogs();
        if (dialogsCounter == 0) {
            printSystemMessage("Wpisz odpowiadającą opcji cyfrę [1-5] a następnie naciśnij [ENTER]");
        } else {
            printSystemMessage("Wybierz jedną z opcji:");
        }
        System.out.println();
        for (int i = 0; i < dialogs.size(); i++) {
            System.out.printf("%d. %s\n",i+1,dialogs.get(i));
        }
    }

    private void printResult(DialogResult dialogResult) {
        printDialogLine(dialogResult.getPlayerName(), dialogResult.getPlayerDialog());
        printSystemMessages(dialogResult.getSystemMessages());
        if (dialogResult.getNpcResponse().isEmpty()) {
            return;
        }
        System.out.println();
        printDialogLine(dialogResult.getNpcName(),dialogResult.getNpcResponse());
        System.out.println();
    }

    private static void printDialogLine(String name, String line) {
        System.out.printf("%s: %s\n", name, line);
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
        System.out.println("Wypite darmowe piwa: " + stats.get(ItemType.FREE_BEER));
        System.out.println("Zjedzone schabowe: " + stats.get(ItemType.FOOD));
        System.out.println("Wynajęte pokoje: " + stats.get(ItemType.ROOM));
    }

    private void opening() {
        System.out.println("\n\n\t\t\t\tKARCZMARZ 2025\n" + "\t<Oto remake mojej pierwszej aplikacji!>\n\n"
                +  "Version: 1.0\n" + "Author: Daniel 'Dixu' Szlicht\n\n"
                + "\t#Naciśnij [ENTER] aby kontynuować");
        new Scanner(System.in).nextLine();
        clear();
    }
}
