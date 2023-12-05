package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Helper {

    private static final String databaseConnectString = "jdbc:h2:./data/InventoryManager";
    private static final String databaseUser = "sa";
    private static final String databasePassword = "ist412tean1";


    private Helper() {
    }


    public static Connection geDatabaseConnection() throws SQLException {
        try {
            return DriverManager.getConnection(databaseConnectString, databaseUser, databasePassword);
        }catch (Exception e){
            throw e;
        }
    }
}

