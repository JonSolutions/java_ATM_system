package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        loginButton.setForeground(Color.blue);
        loginButton.setPreferredSize(new Dimension(280, 30));
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        MyUtils myUtils = new MyUtils();
        myUtils.buttonEffects(loginButton);
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
                    if (usernameField.getText().equals("12345678") && passwordField.getText().equals("12345678")) {
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
        createAccountPanel.setPreferredSize(new Dimension(300, 40));
        JButton createAccountButton = new JButton("new account?");
        createAccountButton.setForeground(Color.blue);
        createAccountButton.setPreferredSize(new Dimension(280, 30));
        createAccountButton.setFont(new Font("Tahoma", Font.BOLD, 12));
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
