package src.Tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.Access;
import src.main.Helper;

import java.util.Map;

public class HelperTest {
    @Test
    public void inventoryListTest(){
        String employeeId = "123456989";
        String password = "adminpassword";

    }
    @Test
    public void countUniqueItemsTest(){
        String[] items = {
                "Heer's Salt and Vinegar Potato Chips",
                "Heer's Salt and Vinegar Potato Chips",
                "Pepsi Soda",
                "Heer's Salt and Vinegar Potato Chips",
                "Pepsi Soda",
        };
        Map<String, Integer> uniqueItems = Helper.countUniqueItems(items);
        assertSame(uniqueItems.get("Heer's Salt and Vinegar Potato Chips"), 3);
        assertSame(uniqueItems.get("Pepsi Soda"), 2);
    }
    @Test
    public void testSetAccess(){
        String employeeId = "123456989";
        String password = "adminpassword";
        assertSame(Helper.getAccess(), Access.USER);
        boolean connect = Helper.attemptLogin(employeeId, password);
        Access actualAccess = Helper.getAccess();
        assertSame(actualAccess, Access.ADMIN);
        Helper.resetAccess();
    }
}
