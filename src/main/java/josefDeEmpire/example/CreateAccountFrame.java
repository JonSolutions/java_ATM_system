package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

import static josefDeEmpire.example.JdbcCrud.users;

public class CreateAccountFrame {
    CreateAccountFrame() {
        JFrame frame = new JFrame("Create Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 490);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(500, 50));
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setPreferredSize(new Dimension(100, 40));
        firstNameLabel.setForeground(Color.red);
        JTextField firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(300, 30));
        firstNameField.setFont(new Font("Arial", Font.BOLD, 15));
        panel1.add(firstNameLabel);
        panel1.add(firstNameField);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(500, 50));
        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setPreferredSize(new Dimension(100, 40));
        lastNameLabel.setForeground(Color.red);
        JTextField lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(300, 30));
        lastNameField.setFont(new Font("Arial", Font.BOLD, 15));
        panel2.add(lastNameLabel);
        panel2.add(lastNameField);

        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(500, 50));
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setPreferredSize(new Dimension(100, 40));
        usernameLabel.setForeground(Color.red);
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300, 30));
        usernameField.setFont(new Font("Arial", Font.BOLD, 15));
        panel3.add(usernameLabel);
        panel3.add(usernameField);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        panel4.setPreferredSize(new Dimension(500, 50));
        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setPreferredSize(new Dimension(100, 40));
        phoneLabel.setForeground(Color.red);
        JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(300, 30));
        phoneField.setFont(new Font("Arial", Font.BOLD, 15));
        panel4.add(phoneLabel);
        panel4.add(phoneField);

        JPanel panel5 = new JPanel();
        panel5.setPreferredSize(new Dimension(500, 50));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setPreferredSize(new Dimension(100, 40));
        passwordLabel.setForeground(Color.red);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 30));
        passwordField.setFont(new Font("Arial", Font.BOLD, 20));
        panel5.add(passwordLabel);
        panel5.add(passwordField);

        JPanel panel6 = new JPanel();
        panel6.setPreferredSize(new Dimension(500, 50));
        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setPreferredSize(new Dimension(100, 40));
        confirmPasswordLabel.setForeground(Color.red);
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(new Dimension(300, 30));
        confirmPasswordField.setFont(new Font("Arial", Font.BOLD, 20));
        panel6.add(confirmPasswordLabel);
        panel6.add(confirmPasswordField);

        JPanel panel7 = new JPanel();
        panel7.setPreferredSize(new Dimension(500, 50));
        JButton CreateButton = new JButton("Create Account");
        CreateButton.setPreferredSize(new Dimension(480, 40));
        CreateButton.addActionListener(e -> {
            if(e.getSource() == CreateButton) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String username = usernameField.getText();
                String phoneNumber = phoneField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

                if(firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all the required fields");
                }else{
                    if(password.equals(confirmPassword)) {
                        try {
                            users(firstName, lastName, username, phoneNumber, password);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        String text = "Congratulations " + firstName + ". Account Creation Successful. \nYour username is: " + username + "\n Your phone is: " + phoneNumber + ". \nDo you want to proceed to Login??\n";
                        int response = JOptionPane.showConfirmDialog(frame, text,"Confirm!!", JOptionPane.OK_CANCEL_OPTION);
                        if(response == JOptionPane.OK_OPTION) {
                            frame.dispose();
                            new LoginFrame();
                        }else if(response == JOptionPane.CANCEL_OPTION) {
                            String op = "You can always login anytime!! GoodBye for now!!";
                            JOptionPane.showMessageDialog(frame, op, "GoodBye", JOptionPane.PLAIN_MESSAGE);
                            frame.dispose();
                        }

                    }else{
                        JOptionPane.showMessageDialog(frame, "Passwords do not match!!", "Password Error!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel7.add(CreateButton);

        JPanel panel8 = new JPanel();
        panel8.setPreferredSize(new Dimension(500, 50));
        JButton backButton = new JButton("Go Back");
        backButton.setPreferredSize(new Dimension(480, 40));
        backButton.addActionListener(e -> {
            if(e.getSource() == backButton) {
                frame.dispose();
                new CreateOrLoginFrame();
            }

        });
        panel8.add(backButton);



        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);
        frame.add(panel7);
        frame.add(panel8);
        frame.setVisible(true);
    }


}
