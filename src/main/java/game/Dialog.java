package game;

public class Dialog {
    private String text;
    private String response;

    public Dialog(String text, String response) {
        this.text = text;
        this.response = response;
    }

    public String getText() {
        return text;
    }

    public String getResponse() {
        return response;
    }
}
