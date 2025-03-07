package game;

public class Dialog {
    private int id;
    private String text;
    private String response;

    public Dialog(int id, String text, String response) {
        this.id = id;
        this.text = text;
        this.response = response;
    }


    public String getText() {
        return text;
    }

    public String getResponse() {
        return response;
    }

    public int getId() {
        return id;
    }
}
