package game;

import java.util.List;

public class Game {

    private final DialogRepository dialogRepository = new DialogRepository();

    public List<String> getDialogs() {
        return dialogRepository.loadAllDialogs().stream()
                .map(Dialog::getText)
                .toList();
    }

    public String selectOption(int answerIndex) {
        List<Dialog> dialogs = dialogRepository.loadAllDialogs();
        return dialogs.get(answerIndex).getResponse();
    }
}
