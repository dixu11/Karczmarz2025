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
        List<String> dialogs = game.getDialogs();
        showOptions(dialogs);
        int answerNr = readAnswer(1,dialogs.size());
        String answer = game.selectOption(answerNr - 1);
        System.out.println(answer);
    }

    private void showOptions(List<String> dialogs) {
        for (int i = 0; i < dialogs.size(); i++) {
            System.out.printf("%d. %s\n",i+1,dialogs.get(i));
        }
    }
}
