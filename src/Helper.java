package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Helper {

    private static final String databaseConnectString = "jdbc:h2:./data/InventoryManager";
    private static final String databaseUser = "sa";
    private static final String databasePassword = "ist412tean1";
    private static ArrayList<Item> items;

    static {
        try {
            items = getInventoryItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Helper() {

    }

    public static Connection geDatabaseConnection() throws SQLException {
        try {
            return DriverManager.getConnection(databaseConnectString, databaseUser, databasePassword);
        }catch (Exception e){
            throw e;
        }
    }
    private static ArrayList<Item> getInventoryItems() throws SQLException{
        DatabaseConnection db = new DatabaseConnection();
        return db.getItems();
    }

    public static ArrayList<String> getInventoryList(){
        ArrayList<String> item_names = new ArrayList<>();
        for(Item item: items){
            item_names.add(item.getName());
        }
        return item_names;
    }
    //finish me
    public static Item getItem(String itemName){
        for(Item item: items){
            if(item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    }

    public static Map<String, Integer> countUniqueItems(String[] items){
        Map<String, Integer> uniqueItems = new HashMap<>();
        for(String item: items){
            if(!uniqueItems.containsKey(item)){
                uniqueItems.put(item,1);
            }else{
                uniqueItems.put(item,uniqueItems.get(item)+1);
            }
        }
        return uniqueItems;
    }
    public static void updateItems(String[] items) throws SQLException{
        DatabaseConnection db = new DatabaseConnection();
        Map<String, Integer> uniqueItems = countUniqueItems(items);
        for(Map.Entry<String, Integer> entry: uniqueItems.entrySet()){
            db.updateItems(entry.getKey(), entry.getValue());
        }
    }
}

