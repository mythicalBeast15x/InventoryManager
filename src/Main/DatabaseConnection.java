package Main;
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
    public ArrayList<Item> getItems() throws SQLException{
        ArrayList<Item> items = new ArrayList<>();
        String sqlQuery = "Select * from Item;";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    String id = resultSet.getString("item_id");
                    String name = resultSet.getString("item_name");
                    String desc = resultSet.getString("item_desc");
                    double cost = resultSet.getDouble("item_cost");
                    String lotNum = resultSet.getString("lot_num");
                    //String count = resultSet.getString("count");
                    Item item = new Item(name, id, desc, cost, lotNum);
                    items.add(item);
                }
            }
        }
        return items;
    }

    public boolean checkCredentials(int id, String passwordAttempt) throws SQLException{
        boolean passwordCorrect = false;
        String sqlQuery = "Select password from Credentials where employee_id = ? ;";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                String password = resultSet.getString("password");
                passwordCorrect = (password.equals(passwordAttempt));
            }
        }
        return passwordCorrect;
    }
    public void updateItems(String itemID, int itemCount) throws SQLException{
        String sqlQuery = "UPDATE Item SET count = ? WHERE item_id = ?";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, itemCount);
            preparedStatement.setString(2, itemID);

            preparedStatement.executeUpdate();

        }
    }


}
