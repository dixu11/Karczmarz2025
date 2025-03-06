package game;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {

   private final Game game = new Game();

    public void start() {
        System.out.println("Witaj w mojej karczmie! Na co masz ochotę?");
        showOptions();
        int answerNr = readAnswer();
        String answer = game.selectOption(answerNr - 1);
        System.out.println(answer);
    }

    private void showOptions() {
        List<String> dialogs = game.getDialogs();
        for (int i = 0; i < dialogs.size(); i++) {
            System.out.printf("%d. %s\n",i+1,dialogs.get(i));
        }
    }

    private int readAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz numer wybranej opcji:");
        return scanner.nextInt();
    }
}
