package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

public class LoginFrame {
    LoginFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.lightGray);


        JPanel labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(300, 40));
        labelPanel.setLayout(new FlowLayout());
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        usernameLabel.setForeground(Color.red);
        labelPanel.add(usernameLabel);

        JPanel usernamePanel = new JPanel();
        usernamePanel.setPreferredSize(new Dimension(300, 40));
        usernamePanel.setLayout(new FlowLayout());
        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Serif", Font.BOLD, 20));
        usernameField.setPreferredSize(new Dimension(280, 30));
        usernamePanel.add(usernameField);

        JPanel passwordLabelPanel = new JPanel();
        passwordLabelPanel.setPreferredSize(new Dimension(300, 40));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.red);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passwordLabelPanel.add(passwordLabel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setPreferredSize(new Dimension(300, 40));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(280, 30));
        passwordField.setFont(new Font("Serif", Font.BOLD, 20));
        passwordPanel.add(passwordField);

         JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(300, 40));
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.green);
        loginButton.setForeground(Color.blue);
        loginButton.setPreferredSize(new Dimension(280, 30));
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        loginButton.addActionListener(e -> {
            if (usernameField.getText().equals("admin") && passwordField.getText().equals("admin")) {
                frame.dispose();
                new HomeFrame();
            }
        });
        buttonPanel.add(loginButton);
        frame.add(labelPanel);
        frame.add(usernamePanel);
        frame.add(passwordLabelPanel);
        frame.add(passwordPanel);
        frame.add(buttonPanel);
        frame.setVisible(true);
    }
}
