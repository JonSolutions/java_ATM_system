package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateOrLoginFrame {
    CreateOrLoginFrame() {
        JFrame frame = new JFrame("Josef DeEmpire Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().setBackground(Color.cyan);

        JLabel label = new JLabel("Welcome to Josef DeEmpire Banking!");
        JLabel label2 = new JLabel("Glad to have you here!! ");
        JLabel label3 = new JLabel("Have an account? Proceed to login or Create a new account.");
        frame.add(label);
        frame.add(label2);
        frame.add(label3);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginPanel.setBackground(Color.lightGray);
        loginPanel.setPreferredSize(new Dimension(400, 50));
        JButton loginButton = new JButton("Login To Account");
        loginButton.setPreferredSize(new Dimension(380, 40));
        MyUtils myUtils = new MyUtils();
        myUtils.buttonEffects(loginButton);
        loginButton.addActionListener(e -> {
            if (e.getSource() == loginButton) {
                frame.dispose();
                new LoginFrame();
            }
        });
        loginPanel.add(loginButton);

        JPanel createAccountPanel = new JPanel();
        createAccountPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        createAccountPanel.setBackground(Color.lightGray);
        createAccountPanel.setPreferredSize(new Dimension(400, 50));
        JButton createAccountButton = new JButton("New Account?");
        createAccountButton.setPreferredSize(new Dimension(380, 40));
        createAccountButton.addActionListener(e -> {
            if (e.getSource() == createAccountButton) {
                frame.dispose();
                new CreateAccountFrame();
            }
        });
        createAccountPanel.add(createAccountButton);


        frame.add(loginPanel);
        frame.add(createAccountPanel);
        frame.setVisible(true);
    }
}
