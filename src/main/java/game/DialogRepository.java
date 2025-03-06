package game;

import java.util.List;

public class DialogRepository {

    public List<Dialog> loadAllDialogs() {
        return List.of(new Dialog("Opcja 1", "Odpowiedź 1"),
                new Dialog("Opcja 2", "Odpowiedź 2"));
    }
}
