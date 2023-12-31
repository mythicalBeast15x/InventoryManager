package src.Tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import src.main.LoginUI;
class LoginUITest {

    @Test
    void incorrectInfoShouldNotWork(){
        LoginUI loginUI = new LoginUI();
        assertEquals(false, loginUI.attemptLogin("admin", "NotARealPassword"));
    }
    @Test
    void correctInfoShouldWork(){
        LoginUI loginUI = new LoginUI();
        assertEquals(true, loginUI.attemptLogin("admin", "password"));
    }
}