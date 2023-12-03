package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginUI extends JFrame implements ActionListener {
    JPasswordField password;
    JLabel label_password;
    JLabel label_username;
    JLabel message;
    JLabel headTitle;
    JTextField username;
    JButton btn;

    private JButton registerButton;

    public LoginUI(){
        setTitle("Login UI Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        this.setLayout(null);

        label_password = new JLabel("Password");
        label_password.setBounds(200,250,100,40);

        label_username = new JLabel("Employee ID");
        label_username.setBounds(200,200,100,40);

        headTitle = new JLabel("Star Spangled Snacks");
        headTitle.setFont(label_username.getFont().deriveFont(24.0F));
        headTitle.setBounds(10, 10, 400, 40);

        username = new JTextField();
        username.setBounds(300, 200, 300, 40);

        password = new JPasswordField();
        password.setBounds(300,250,300,40);

        btn = new JButton("Sign in");
        btn.setBounds(400,300,100,40); //edit this
        btn.addActionListener(this);

        message = new JLabel("Error: Incorrect Username or Password"); //failed login message
        message.setBounds(330,340,300,40);
        message.setForeground(Color.RED);
        message.setVisible(false);

        registerButton = new JButton("Register");
        registerButton.setBounds(400, 350, 100, 40);
        registerButton.addActionListener(this);



        this.add(label_username);
        this.add(username);
        this.add(label_password);
        this.add(password);
        this.add(btn);
        this.add(message);
        this.add(headTitle);
        this.add(registerButton);




        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn) {
            Boolean correctInfo = false;
            //retrieving user input
            String userInput = username.getText();
            String passInput = String.valueOf(password.getPassword());

            //creating test info
            ArrayList<UserInfo> users = new ArrayList<UserInfo>();
            UserInfo user1 = new UserInfo("admin", "password");
            UserInfo user2 = new UserInfo("coolcat", "password");
            UserInfo user3 = new UserInfo("Sharkboy", "password");
            UserInfo user4 = new UserInfo("", "");
            users.add(user1);
            users.add(user2);
            users.add(user3);
            users.add(user4);

            //testing if username and password match
            for (int i = 0; i < users.size(); i++){
                if (userInput.equals(users.get(i).getUsername())){ //need a break somewhere here so it doesnt have to iterate through whole list but rlly not that important with filler data
                    if (passInput.equals(users.get(i).getPassword())){
                        correctInfo = true;
                        GUI myGui = new GUI();
                        myGui.show();
                        dispose();
                    }
                }
            }
            if (!correctInfo){
                message.setVisible(true);
                username.setText("");
                password.setText("");
            }

        } else if (e.getSource() == registerButton) {
            EmployeeRegistrationGUI employeeRegistrationGUI = new EmployeeRegistrationGUI();
            employeeRegistrationGUI.setVisible(true);
        }



    }
}


