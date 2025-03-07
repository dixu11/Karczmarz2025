package game;

import java.util.List;

public class DialogOptions {
    private List<String> dialogs;
    private List<String> systemMessages;

    public DialogOptions(List<String> dialogs, List<String> systemMessages) {
        this.dialogs = dialogs;
        this.systemMessages = systemMessages;
    }

    public List<String> getDialogs() {
        return dialogs;
    }

    public List<String> getSystemMessages() {
        return systemMessages;
    }
}
