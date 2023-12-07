package src.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase{

    public static void main(String[] args) {
        try {
            // Connect to H2 database (embedded mode)
            Connection connection = DriverManager.getConnection("jdbc:h2:./data/InventoryManager", "sa", "ist412tean1");

            // Create a statement
            Statement statement = connection.createStatement();

            // SQL statement to create a table
            /*
            String createAccessTableSQL = "CREATE TABLE IF NOT EXISTS Access(access_level varchar(10), primary key(access_level));";
            String createLotTableSQL = "CREATE TABLE IF NOT EXISTS Lot(lot_num varchar(5), primary key(lot_num));";
            String createEmployeeTableSQL = "CREATE TABLE IF NOT EXISTS Employee(employee_id numeric(9,0), first_name varchar(20), last_name varchar(20), access_level varchar(10), primary key(employee_id), foreign key(access_level) references Access(access_level));";
            String createCredentialsTableSQL = "CREATE TABLE IF NOT EXISTS Credentials(employee_id numeric(9,0), password varchar(50), primary key(employee_id), foreign key(employee_id) references Employee(employee_id)); ";
            String createItemTableSQL = "CREATE TABLE IF NOT EXISTS Item(item_id varchar(50), item_name varchar(50), item_desc text(100), item_cost numeric(9,2), lot_num varchar(5), primary key(item_id), foreign key(lot_num) references Lot(lot_num)); ";

            // Execute SQL statement
            statement.execute(createAccessTableSQL);
            statement.execute(createLotTableSQL);
            statement.execute(createEmployeeTableSQL);
            statement.execute(createCredentialsTableSQL);
            statement.execute(createItemTableSQL);

            System.out.println("Database and tables created successfully.");
            */
            // Insert Data into Access table
            //statement.execute("INSERT INTO Access VALUES ('Admin');");
            //statement.execute("INSERT INTO Access VALUES ('Employee');");

            // Insert data into Lot table
            //statement.execute("INSERT INTO Lot VALUES ('L001');");
            //statement.execute("INSERT INTO Lot VALUES ('L002');");

            // Insert data into Employee table
            //statement.execute("INSERT INTO Employee VALUES (123456989, 'John', 'Doe', 'Admin');");
            //statement.execute("INSERT INTO Employee VALUES (239874018, 'Jane', 'Doe', 'Employee');");

            // Insert data into Credentials table
            //statement.execute("INSERT INTO Credentials VALUES (123456989, 'adminpassword');");
            //statement.execute("INSERT INTO Credentials VALUES (239874018, 'mypassword2');");

            // Insert data into Item table
            //statement.execute("INSERT INTO Item VALUES ('I001', 'Heer''s Salt and Vinegar Potato Chips', 'The Originals, sure to bring a nostalgic taste to your mouth', 3.99, 'L001');");
            //statement.execute("INSERT INTO Item VALUES ('I002', 'Pepsi Soda', 'The classic refreshing drink', 2.99, 'L002');");
            //String alterTableSql = "ALTER TABLE Item ADD COLUMN count INT" ;
            //String alterTableSql = "Update Item set count = 100" ;
            //statement.executeUpdate(alterTableSql);
            // Close the resources
            statement.close();
            connection.close();

            System.out.println("Data Inserted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
