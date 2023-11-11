package src;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame;
    private JList<String> itemList;
    private JTextArea itemInfoArea;

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

        // Sample item list
        String[] items = {"Heer's Salt and Vinegar Potato Chips", "Lay's Classic Potato Chips", "Fritos The Original Corn Chips", "Doritos Nacho Cheese", "More Chips", "Even More Chips", "Soda"};

        // Creating the JList
        itemList = new JList<>(items);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setSelectedIndex(0);
        itemList.setVisibleRowCount(4);

        // Adding a border to the JList
        itemList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Adding the JList to a JScrollPane
        JScrollPane listScroller = new JScrollPane(itemList);
        listScroller.setPreferredSize(new Dimension(250, 100));

        // Item info area
        itemInfoArea = new JTextArea(5, 20);
        itemInfoArea.setEditable(false);
        JScrollPane infoScroller = new JScrollPane(itemInfoArea);

        // Main content panel with GridBagLayout
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Adding list scroller to the content panel
        gbc.gridx = 0; // First column
        gbc.gridy = 0; // First row
        gbc.insets = new Insets(10, 10, 10, 10);
        contentPanel.add(listScroller, gbc);

        // Adding item info area to the content panel
        gbc.gridx = 1; // Second column
        gbc.gridy = 0; // First row (same as list scroller)
        contentPanel.add(infoScroller, gbc);

        frame.add(contentPanel, BorderLayout.CENTER);

        // Buttons
        JButton logoutButton = new JButton("Logout");
        JButton updateInfoButton = new JButton("Update-Info");

        updateInfoButton.addActionListener(e -> {
            Modify modifyWindow = new Modify();
            modifyWindow.show();
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
}
