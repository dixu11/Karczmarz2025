package game;

import java.util.List;

public class ConsoleController {

    public void start() {
        Game game = new Game();
        System.out.println("Witaj w mojej karczmie! Na co masz ochotę?");
        List<String> dialogs = game.getDialogs();
        for (int i = 0; i < dialogs.size(); i++) {
            System.out.printf("%d. %s\n",i+1,dialogs.get(i));
        }
    }
}
