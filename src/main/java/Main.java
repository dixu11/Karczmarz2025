import game.ConsoleController;
import game.Game;
import repository.NpcJsonRepository;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new NpcJsonRepository());
        ConsoleController consoleController = new ConsoleController(game);
        consoleController.start();
    }
}
