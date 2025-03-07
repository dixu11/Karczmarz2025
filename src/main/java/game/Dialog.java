package game;

public class Dialog {
    private int id;
    private String text;
    private String response;
    private Node changeNode;
    private Item buyItem;

    public Dialog(int id, String text, String response,ItemType buyItemType) {
        this.id = id;
        this.text = text;
        this.response = response;
        if (buyItemType != null) {
            buyItem = new ItemFactory().getItemByType(buyItemType);
        }
    }

    public void setChangeNode(Node changeNode) {
        this.changeNode = changeNode;
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

    public Node getChangeNode() {
        return changeNode;
    }

    public boolean hasChangeNode() {
        return changeNode != null;
    }

    public boolean hasBuyItem() {
        return buyItem != null;
    }

    public Item getBuyItem() {
        return buyItem;
    }
}
