package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

public class LoginFrame {
    LoginFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.green);


        JPanel usernamePanel = new JPanel();
        usernamePanel.setPreferredSize(new Dimension(300, 50));
        usernamePanel.setBackground(Color.magenta);
        usernamePanel.setLayout(new FlowLayout());
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.red);
        JTextField usernameField = new JTextField(15);
        usernameField.setPreferredSize(new Dimension(300, 30));
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setPreferredSize(new Dimension(300, 50));
        passwordPanel.setBackground(Color.yellow);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.red);
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setPreferredSize(new Dimension(300, 30));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(300, 50));
        buttonPanel.setBackground(Color.blue);
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.yellow);
        loginButton.setForeground(Color.red);
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        loginButton.addActionListener(e -> {
            if (usernameField.getText().equals("admin") && passwordField.getText().equals("admin")) {
                frame.dispose();
                new HomeFrame();
            }
        });
        buttonPanel.add(loginButton);

        frame.add(usernamePanel);
        frame.add(passwordPanel);
        frame.add(buttonPanel);
        frame.setVisible(true);
    }
}
