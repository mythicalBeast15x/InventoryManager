package src;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame;
    private JList<String> shopList;
    private JList<String> cartList;
    private JButton selectButton;
    private JButton removeFromCartButton;

    public GUI() {
        frame = new JFrame("Item Selection");
        frame.setLayout(new BorderLayout());

        // Panel for title and slogan
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.PAGE_AXIS));

        // Title
        JLabel titleLabel = new JLabel("Star Spangled Snacks", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 35));
        titlePanel.add(titleLabel);

        // Slogan
        JLabel sloganLabel = new JLabel("For all your 4th of July BBQ Needs!", SwingConstants.CENTER);
        sloganLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        titlePanel.add(sloganLabel);

        frame.add(titlePanel, BorderLayout.NORTH);

        // Sample item list for Shop
        String[] shopItems = {"Heer's Salt and Vinegar Potato Chips", "Lay's Classic Potato Chips", "Fritos The Original Corn Chips", "Doritos Nacho Cheese", "More Chips", "Even More Chips", "Soda"};
        shopList = new JList<>(shopItems);
        shopList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        shopList.setSelectedIndex(0);
        shopList.setVisibleRowCount(4);
        shopList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // ScrollPane for shopList
        JScrollPane shopListScroller = new JScrollPane(shopList);

        // Cart list (initially empty)
        cartList = new JList<>(new DefaultListModel<>());
        cartList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cartList.setSelectedIndex(0);
        cartList.setVisibleRowCount(4);
        cartList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // ScrollPane for cartList
        JScrollPane cartListScroller = new JScrollPane(cartList);

        // Main content panel with GridBagLayout
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Label for Shop
        JLabel shopLabel = new JLabel("Shop");
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(shopLabel, gbc);

        // Adding shop list scroller to content panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(shopListScroller, gbc);

        // Select button under Shop list
        selectButton = new JButton("Select");
        selectButton.addActionListener(e -> {
            String selectedItem = shopList.getSelectedValue();
            if (selectedItem != null) {
                DefaultListModel<String> cartModel = (DefaultListModel<String>) cartList.getModel();
                cartModel.addElement(selectedItem);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPanel.add(selectButton, gbc);

        // Remove from cart button under cart list
        removeFromCartButton = new JButton("Remove From Cart");
        removeFromCartButton.addActionListener(e -> {
            String selectedItem = cartList.getSelectedValue();
            if (selectedItem != null) {
                DefaultListModel<String> cartModel = (DefaultListModel<String>) cartList.getModel();
                cartModel.removeElement(selectedItem);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPanel.add(removeFromCartButton, gbc);

        // Label for Cart
        JLabel cartLabel = new JLabel("Cart");
        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPanel.add(cartLabel, gbc);

        // Adding cart list scroller to content panel
        gbc.gridy = 0;
        gbc.gridheight = 4; // Make cart list span two rows
        contentPanel.add(cartListScroller, gbc);

        frame.add(contentPanel, BorderLayout.CENTER);

        // Buttons
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            LoginUI newUI2 = new LoginUI();
            frame.dispose();
        });

        JButton updateInfoButton = new JButton("Check-out");
        updateInfoButton.addActionListener(e -> {
            DefaultListModel<String> cartModel = (DefaultListModel<String>) cartList.getModel();

            if(cartModel.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Your cart is empty!");
            }
            else{
                Modify checkoutWindow = new Modify();

                ListModel<String> model = cartList.getModel();
                String[] items = new String[model.getSize()];
                for (int i = 0; i < model.getSize(); i++) {
                    items[i] = model.getElementAt(i);
                }

                checkoutWindow.setListData(items);
                checkoutWindow.show();
            }
        });

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(logoutButton);
        buttonPanel.add(updateInfoButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void show() {
        frame.setVisible(true);
    }
    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.show();
        });
    }
}
