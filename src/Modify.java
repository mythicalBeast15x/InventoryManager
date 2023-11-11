package src;

import javax.swing.*;
import java.awt.*;

public class Modify {
    private JFrame frame;

    public Modify() {
        frame = new JFrame("Modify Item");
        frame.setLayout(new BorderLayout());

        // Add components to your Modify frame here
        // For example, a label:
        JLabel label = new JLabel("Modify Item Details", SwingConstants.CENTER);
        frame.add(label, BorderLayout.CENTER);

        // Frame settings
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
    }

    public void show() {
        frame.setVisible(true);
    }
}