package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class EmployeeRegistrationGUI extends JFrame {
    private JTextField firstNameField, lastNameField;
    private JPasswordField passwordField;
    private JLabel employeeIdLabel;
    private JButton registerButton;
    private int generatedId; // Variable to store the generated ID

    public EmployeeRegistrationGUI() {
        generateEmployeeId(); // Generate ID immediately
        createUI();
    }

    private void createUI() {
        setTitle("Employee Registration");
        setLayout(new GridLayout(5, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("First Name:"));
        firstNameField = new JTextField(20);
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField(20);
        add(lastNameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        add(passwordField);

        add(new JLabel("Employee ID:"));
        employeeIdLabel = new JLabel(String.valueOf(generatedId)); // Display generated ID
        add(employeeIdLabel);

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                completeRegistration(generatedId); // Use the already generated ID
            }
        });
        add(registerButton);

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void generateEmployeeId() {
        Random random = new Random();
        generatedId = random.nextInt(10000); // Generate a random number for ID
    }

    private void completeRegistration(int id) {
        // Display user info in a popup
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        JOptionPane.showMessageDialog(this,
                "Registration Successful!\nEmployee ID: " + id +
                        "\nName: " + firstName + " " + lastName,
                "Registration Info", JOptionPane.INFORMATION_MESSAGE);

        // Automatic login (Assuming GUI is your main application window)
        // Replace GUI with your main application window class
        // GUI mainApp = new GUI();
        // mainApp.show();
         dispose(); // Close the registration window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmployeeRegistrationGUI::new);
    }
}
