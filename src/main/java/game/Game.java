package game;

import java.util.List;

public class Game {

    public List<Dialog> getDialogs() {
        DialogRepository dialogRepository = new DialogRepository();
        return dialogRepository.loadAllDialogs();
    }
}
