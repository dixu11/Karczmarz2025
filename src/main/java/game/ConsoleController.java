package game;
import java.util.List;

import static common.JavaUtils.clear;
import static common.JavaUtils.readAnswer;

public class ConsoleController {

   private final Game game;

    public ConsoleController(Game game) {
        this.game = game;
    }

    public void start() {
        System.out.println("Witaj w mojej karczmie! Na co masz ochotę?");
        while(true){
            executeDialog();
        }
    }

    private void executeDialog() {
        DialogOptions dialogOptions = game.getDialogs();
        showOptions(dialogOptions);
        int answerNr = readAnswer(1,dialogOptions.getDialogs().size());
        clear();
        DialogResult dialogResult = game.selectOption(answerNr - 1);
        printResult(dialogResult);
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
}
