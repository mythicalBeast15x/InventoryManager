package src;

public class Item {
    private final String name;
    private final String itemID;
    private final String description;
    private final double cost;
    private final String lotNum;

    Item(String name, String itemID, String description, double cost, String lotNum){
        this.name = name;
        this.itemID = itemID;
        this.description = description;
        this.cost = cost;
        this.lotNum = lotNum;
    }

    public String getName() {
        return this.name;
    }

    public String getItemID() {
        return this.itemID;
    }

    public String getDescription() {
        return this.description;
    }

    public double getCost() {
        return this.cost;
    }

    public String getLotNum(){
        return this.lotNum;
    }


}
