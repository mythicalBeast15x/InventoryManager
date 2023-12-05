package src.Tests;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

import src.GUI;
class GUITest {
    @Test
    void addingItemToCartShouldIncreaseCartSize(){
        GUI gui = new GUI();
        gui.addItemToCart("TestItem");
        DefaultListModel<String> cartModel = (DefaultListModel<String>) gui.getCartList().getModel();
        assertEquals(false, cartModel.isEmpty());
    }
    @Test
    void removingItemFromCartShouldMakeCartEmpty(){
        GUI gui = new GUI();
        gui.addItemToCart("TestItem");
        gui.removeItemFromCart("TestItem");
        DefaultListModel<String> cartModel = (DefaultListModel<String>) gui.getCartList().getModel();
        assertEquals(true, cartModel.isEmpty());
    }
}