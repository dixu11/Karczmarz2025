package game;
import java.util.List;
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
        List<String> dialogs = game.getDialogs();
        showOptions(dialogs);
        int answerNr = readAnswer(1,dialogs.size());
        DialogResult dialogResult = game.selectOption(answerNr - 1);
        printResult(dialogResult);
    }

    private void showOptions(List<String> dialogs) {
        for (int i = 0; i < dialogs.size(); i++) {
            System.out.printf("%d. %s\n",i+1,dialogs.get(i));
        }
    }

    private void printResult(DialogResult dialogResult) {
        System.out.printf("%s: %s\n",dialogResult.getPlayerName(),dialogResult.getPlayerDialog());
        for (String systemMessage : dialogResult.getSystemMessages()) {
            System.out.printf("\t*: %s\n",systemMessage);
        }
        System.out.printf("%s: %s\n",dialogResult.getNpcName(),dialogResult.getNpcResponse());
    }
}
