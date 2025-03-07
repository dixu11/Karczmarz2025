package game;

import java.util.List;

public class DialogResult {
    private String playerName;
    private String playerDialog;
    private String npcName;
    private String npcResponse;
    private List<String> systemMessages;

    public DialogResult(String playerName, String playerDialog, String npcName, String npcResponse, List<String> systemMessages) {
        this.playerName = playerName;
        this.playerDialog = playerDialog;
        this.npcName = npcName;
        this.npcResponse = npcResponse;
        this.systemMessages = systemMessages;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerDialog() {
        return playerDialog;
    }

    public String getNpcName() {
        return npcName;
    }

    public String getNpcResponse() {
        return npcResponse;
    }

    public List<String> getSystemMessages() {
        return systemMessages;
    }
}
