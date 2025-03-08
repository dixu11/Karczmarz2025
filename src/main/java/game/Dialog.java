package game;

public class Dialog {
    private int id;
    private String text;
    private String response;
    private Node changeNode;
    private Item buyItem;
    private DialogVisibility visibility;
    private int viewedTimes = 0;
    private int selectedTimes = 0;

    public Dialog(int id, String text, String response, ItemType buyItemType, DialogVisibility visibility) {
        this.id = id;
        this.text = text;
        this.response = response;
        this.visibility = visibility;
        if (visibility == null) {
            this.visibility = DialogVisibility.ALWAYS;
        }
        if (buyItemType != null) {
            buyItem = new ItemFactory().getItemByType(buyItemType);
        }
    }

    public boolean isVisible() {
        return switch (visibility){
            case ALWAYS -> true;
            case ONE_TIME -> selectedTimes == 0;
            case ONE_CHANCE -> viewedTimes == 0;
        };
    }

    void seen() {
        viewedTimes++;
    }

    void selected() {
        selectedTimes++;
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
