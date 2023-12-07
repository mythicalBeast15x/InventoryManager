package src.Tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.Helper;


public class LoginDatabaseTest {
    @Test
    public void incorrectUser(){assertFalse(Helper.attemptLogin("admin", "NotARealPassword"));}
    @Test
    public void incorrectPassword(){assertFalse(Helper.attemptLogin("123456989", "NotARealPassword"));}
    @Test
    public void correctUsernameAndPassword(){
        assertTrue(Helper.attemptLogin("123456989", "adminpassword"));}
}
