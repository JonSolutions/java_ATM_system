package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

public class CreateAccountFrame {
    CreateAccountFrame() {
        JFrame frame = new JFrame("Create Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(500, 95));
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setPreferredSize(new Dimension(100, 20));
        firstNameLabel.setForeground(Color.red);
        JTextField firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(300, 20));
        panel1.add(firstNameLabel);
        panel1.add(firstNameField);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(500, 95));
        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setPreferredSize(new Dimension(100, 20));
        lastNameLabel.setForeground(Color.red);
        JTextField lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(300, 20));
        panel2.add(lastNameLabel);
        panel2.add(lastNameField);

        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(500, 95));
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setPreferredSize(new Dimension(100, 20));
        usernameLabel.setForeground(Color.red);
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300, 20));
        panel3.add(usernameLabel);
        panel3.add(usernameField);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        panel4.setPreferredSize(new Dimension(500, 80));
        JLabel emailLabel = new JLabel("Phone Number");
        emailLabel.setPreferredSize(new Dimension(100, 20));
        emailLabel.setForeground(Color.red);
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(300, 20));
        panel4.add(emailLabel);
        panel4.add(emailField);

        JPanel panel5 = new JPanel();
        panel5.setPreferredSize(new Dimension(500, 95));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setPreferredSize(new Dimension(100, 20));
        passwordLabel.setForeground(Color.red);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 20));
        panel5.add(passwordLabel);
        panel5.add(passwordField);

        JPanel panel6 = new JPanel();
        panel6.setPreferredSize(new Dimension(500, 95));
        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setPreferredSize(new Dimension(100, 20));
        confirmPasswordLabel.setForeground(Color.red);
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(new Dimension(300, 20));
        panel6.add(confirmPasswordLabel);
        panel6.add(confirmPasswordField);

        JPanel panel7 = new JPanel();
        panel7.setPreferredSize(new Dimension(500, 95));
        JButton CreateButton = new JButton("Create Account");
        CreateButton.addActionListener(e -> {
            if(e.getSource() == CreateButton) {
                frame.dispose();
                new LoginFrame();
            }
        });
        panel7.add(CreateButton);



        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);
        frame.add(panel7);
        frame.setVisible(true);
    }


}
