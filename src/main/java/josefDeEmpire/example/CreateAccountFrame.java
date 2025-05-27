package josefDeEmpire.example;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static josefDeEmpire.example.JdbcCrud.users;
import static josefDeEmpire.example.MyUtils.buttonEffects;
import static josefDeEmpire.example.MyUtils.textFieldEffects;

public class CreateAccountFrame {
    CreateAccountFrame() {
        JFrame frame = new JFrame("Create Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 490);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.cyan);
        panel1.setPreferredSize(new Dimension(500, 50));
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setPreferredSize(new Dimension(100, 40));
        firstNameLabel.setForeground(Color.black);
        JTextField firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(300, 30));
        firstNameField.setFont(new Font("Arial", Font.BOLD, 15));
        textFieldEffects(firstNameField, "Enter First Name");
        panel1.add(firstNameLabel);
        panel1.add(firstNameField);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.cyan);
        panel2.setPreferredSize(new Dimension(500, 50));
        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setPreferredSize(new Dimension(100, 40));
        lastNameLabel.setForeground(Color.black);
        JTextField lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(300, 30));
        lastNameField.setFont(new Font("Arial", Font.BOLD, 15));
        textFieldEffects(lastNameField, "Enter Last Name");
        panel2.add(lastNameLabel);
        panel2.add(lastNameField);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.cyan);
        panel3.setPreferredSize(new Dimension(500, 50));
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setPreferredSize(new Dimension(100, 40));
        usernameLabel.setForeground(Color.black);
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300, 30));
        usernameField.setFont(new Font("Arial", Font.BOLD, 15));
        textFieldEffects(usernameField, "Enter Username");
        panel3.add(usernameLabel);
        panel3.add(usernameField);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.cyan);
        panel4.setLayout(new FlowLayout());
        panel4.setPreferredSize(new Dimension(500, 50));
        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setPreferredSize(new Dimension(100, 40));
        phoneLabel.setForeground(Color.black);
        JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(300, 30));
        phoneField.setFont(new Font("Arial", Font.BOLD, 15));
        textFieldEffects(phoneField, "Enter Phone Number");
        panel4.add(phoneLabel);
        panel4.add(phoneField);

        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.cyan);
        panel5.setPreferredSize(new Dimension(500, 50));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setPreferredSize(new Dimension(100, 40));
        passwordLabel.setForeground(Color.black);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 30));
        passwordField.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldEffects(passwordField, "Enter Password");
        panel5.add(passwordLabel);
        panel5.add(passwordField);

        JPanel panel6 = new JPanel();
        panel6.setBackground(Color.cyan);
        panel6.setPreferredSize(new Dimension(500, 50));
        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setPreferredSize(new Dimension(100, 40));
        confirmPasswordLabel.setForeground(Color.black);
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(new Dimension(300, 30));
        confirmPasswordField.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldEffects(confirmPasswordField, "Confirm Password");
        panel6.add(confirmPasswordLabel);
        panel6.add(confirmPasswordField);

        JPanel panel7 = new JPanel();
        panel7.setBackground(Color.cyan);
        panel7.setPreferredSize(new Dimension(500, 50));
        JButton CreateButton = new JButton("Create Account");
        CreateButton.setPreferredSize(new Dimension(480, 40));
        buttonEffects(CreateButton);
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
                    if(username.length() < 8 || password.length() < 8 || confirmPassword.length() < 8) {
                        String opi = "Password and Username cant be less than 8 characters";
                        JOptionPane.showMessageDialog(frame, opi, "GoodBye", JOptionPane.PLAIN_MESSAGE);
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
            }
        });
        panel7.add(CreateButton);

        JPanel panel8 = new JPanel();
        panel8.setBackground(Color.cyan);
        panel8.setPreferredSize(new Dimension(500, 50));
        JButton backButton = new JButton("Go Back");
        backButton.setPreferredSize(new Dimension(480, 40));
        buttonEffects(backButton);
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
