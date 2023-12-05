package src;
import org.h2.command.query.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DatabaseConnection {
    private Connection connection;
    DatabaseConnection(){
        try{
            this.connection = Helper.geDatabaseConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();
        String sqlQuery = "Select * from Item;";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    String id = resultSet.getString("item_id");
                    String name = resultSet.getString("item_name");
                    String desc = resultSet.getString("item_desc");
                    double cost = resultSet.getDouble("item_came");
                    String lotNum = resultSet.getString("lot_num");
                    Item item = new Item(name, id, desc, cost, lotNum);
                    items.add(item);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return items;
    }

}
