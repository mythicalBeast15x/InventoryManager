package src.Tests;

import org.junit.jupiter.api.Test;
import src.main.GUI;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;


class GUITest {
    @Test
    void addingItemToCartShouldIncreaseCartSize(){
        GUI gui = new GUI();
        gui.addItemToCart("TestItem");
        DefaultListModel<String> cartModel = (DefaultListModel<String>) gui.getCartList().getModel();
        assertTrue(cartModel.isEmpty());
    }
    @Test
    void removingItemFromCartShouldMakeCartEmpty(){
        GUI gui = new GUI();
        gui.addItemToCart("TestItem");
        gui.removeItemFromCart("TestItem");
        DefaultListModel<String> cartModel = (DefaultListModel<String>) gui.getCartList().getModel();
        assertTrue(cartModel.isEmpty());
    }
}