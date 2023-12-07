
package Main;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Modify {
    private JFrame frame;
    private JList<String> checkoutList;

    private String[] checkoutItems;

    public Modify() {
        frame = new JFrame("Checkout Window");
        frame.setLayout(new BorderLayout());

        // Checkout title within the window
        JLabel titleLabel = new JLabel("Checkout", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Cart label
        JLabel cartLabel = new JLabel("Cart", SwingConstants.LEFT);

        // Checkout list
        checkoutList = new JList<>();
        checkoutList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroller = new JScrollPane(checkoutList);
        listScroller.setPreferredSize(new Dimension(350, 200));

        // Panel for Cart label and list
        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.add(cartLabel, BorderLayout.NORTH);
        cartPanel.add(listScroller, BorderLayout.CENTER);
        frame.add(cartPanel, BorderLayout.CENTER);

        // Purchase button
        JButton purchaseButton = new JButton("Complete Purchase");
        purchaseButton.addActionListener(e -> {
            try {
                Helper.updateItems(checkoutItems);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(frame, "Thank you for your Purchase!");
            frame.dispose(); // Closes the Modify window
        });

        // Adding the purchase button at the bottom
        frame.add(purchaseButton, BorderLayout.SOUTH);

        // Frame settings
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void show() {
        frame.setVisible(true);
    }

    // Method to update the list items
    public void setListData(String[] items) {
        checkoutList.setListData(items);
        checkoutItems = items;
    }



}