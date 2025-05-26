package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static josefDeEmpire.example.JdbcCrud.currentUser_username;
import static josefDeEmpire.example.JdbcCrud.isValidUser;
import static josefDeEmpire.example.MyUtils.buttonEffects;
import static josefDeEmpire.example.MyUtils.textFieldEffects;

public class LoginFrame {
    LoginFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.cyan);


        JPanel labelPanel = new JPanel();
        labelPanel.setBackground(Color.cyan);
        labelPanel.setPreferredSize(new Dimension(300, 40));
        labelPanel.setLayout(new FlowLayout());
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        usernameLabel.setForeground(Color.black);
        labelPanel.add(usernameLabel);

        JPanel usernamePanel = new JPanel();
        usernamePanel.setBackground(Color.cyan);
        usernamePanel.setPreferredSize(new Dimension(300, 40));
        usernamePanel.setLayout(new FlowLayout());
        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Serif", Font.BOLD, 20));
        usernameField.setPreferredSize(new Dimension(280, 30));
        textFieldEffects(usernameField, "Enter Username");
        usernamePanel.add(usernameField);

        JPanel passwordLabelPanel = new JPanel();
        passwordLabelPanel.setBackground(Color.cyan);
        passwordLabelPanel.setPreferredSize(new Dimension(300, 40));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passwordLabelPanel.add(passwordLabel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Color.cyan);
        passwordPanel.setPreferredSize(new Dimension(300, 40));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(280, 30));
        passwordField.setFont(new Font("Serif", Font.BOLD, 20));
        textFieldEffects(passwordField, "Enter Password");
        passwordPanel.add(passwordField);

         JPanel buttonPanel = new JPanel();
         buttonPanel.setBackground(Color.cyan);
        buttonPanel.setPreferredSize(new Dimension(300, 40));
        JButton loginButton = new JButton("Login");
        loginButton.setForeground(Color.blue);
        loginButton.setPreferredSize(new Dimension(280, 30));
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        buttonEffects(loginButton);
        loginButton.addActionListener(e -> {
            if(e.getSource() == loginButton) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if(username.isEmpty() || password.isEmpty()) {
                    String text = "Enter username and password!";
                    JOptionPane.showMessageDialog(frame,text,"Empty Field(s)!!",JOptionPane.PLAIN_MESSAGE );
                }else if(username.length() < 8 || password.length() < 8) {
                    String tex = "username and password can't be less than 8 characters";
                    JOptionPane.showMessageDialog(frame,tex,"Empty Field(s)!!",JOptionPane.PLAIN_MESSAGE );
                }else{
                    isValidUser(username, password);
                    if (username.equals(currentUser_username)) {
                        frame.dispose();
                        new HomeFrame();
                    }else {
                        String tec = " Incorrect Password or Username ";
                        JOptionPane.showMessageDialog(frame,tec,"Invalid Credentials!!!!",JOptionPane.PLAIN_MESSAGE );
                        usernameField.setText("");
                        passwordField.setText("");
                    }
                }
            }

        });

        JPanel createAccountPanel = new JPanel();
        createAccountPanel.setBackground(Color.cyan);
        createAccountPanel.setPreferredSize(new Dimension(300, 40));
        JButton createAccountButton = new JButton("new account?");
        createAccountButton.setForeground(Color.blue);
        createAccountButton.setPreferredSize(new Dimension(280, 30));
        createAccountButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        buttonEffects(createAccountButton);
        createAccountButton.addActionListener(e -> {
            if(e.getSource() == createAccountButton) {
                frame.dispose();
                new CreateAccountFrame();
            }
        });


        buttonPanel.add(loginButton);
        frame.add(labelPanel);
        frame.add(usernamePanel);
        frame.add(passwordLabelPanel);
        frame.add(passwordPanel);
        frame.add(buttonPanel);
        frame.add(createAccountButton);
        frame.setVisible(true);

    }
}
