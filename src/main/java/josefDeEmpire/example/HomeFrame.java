package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

import static josefDeEmpire.example.JdbcCrud.currentUser_first_name;
import static josefDeEmpire.example.JdbcCrud.currentUser_last_name;
import static josefDeEmpire.example.MyUtils.buttonEffects;

public class HomeFrame {
    HomeFrame(){
        JFrame frame = new JFrame("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 390);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().setBackground(Color.cyan);

        JLabel label = new JLabel("Hello, " + currentUser_first_name + " " + currentUser_last_name + ". Welcome!!");
        frame.add(label);

        JPanel depositPanel = new JPanel();
        depositPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        depositPanel.setBackground(Color.lightGray);
        depositPanel.setPreferredSize(new Dimension(400, 50));
        JButton depositButton = new JButton("Deposit");
        depositButton.setPreferredSize(new Dimension(380, 40));
        buttonEffects(depositButton);
        depositButton.addActionListener(e -> {
            if (e.getSource() == depositButton) {
                frame.dispose();
                new DepositFrame();
            }
        });
        depositPanel.add(depositButton);


        JPanel balancePanel = new JPanel();
        balancePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        balancePanel.setBackground(Color.lightGray);
        balancePanel.setPreferredSize(new Dimension(400, 50));
        JButton balanceButton = new JButton("Check Balance");
        balanceButton.setPreferredSize(new Dimension(380, 40));
        buttonEffects(balanceButton);
        balanceButton.addActionListener(e -> {
            if(e.getSource() == balanceButton) {
                frame.dispose();
                new CheckBalanceFrame();
            }
        });
        balancePanel.add(balanceButton);


        JPanel sendPanel = new JPanel();
        sendPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        sendPanel.setBackground(Color.lightGray);
        sendPanel.setPreferredSize(new Dimension(400, 50));
        JButton sendButton = new JButton("Send Money");
        sendButton.setPreferredSize(new Dimension(380, 40));
        buttonEffects(sendButton);
        sendButton.addActionListener(e -> {
            if(e.getSource() == sendButton){
                frame.dispose();
                new SendMoneyFrame();
            }
        });
        sendPanel.add(sendButton);


        JPanel withDrawPanel = new JPanel();
        withDrawPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        withDrawPanel.setBackground(Color.lightGray);
        withDrawPanel.setPreferredSize(new Dimension(400, 50));
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setPreferredSize(new Dimension(380, 40));
        buttonEffects(withdrawButton);
        withdrawButton.addActionListener(e -> {
            if(e.getSource() == withdrawButton){
                frame.dispose();
                new WithDrawFrame();
            }
        });
        withDrawPanel.add(withdrawButton);

        JPanel newAccountPanel = new JPanel();
        newAccountPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        newAccountPanel.setBackground(Color.lightGray);
        newAccountPanel.setPreferredSize(new Dimension(400, 50));
        JButton newAccountButton = new JButton("Create New Account");
        newAccountButton.setPreferredSize(new Dimension(380, 40));
        buttonEffects(newAccountButton);
        newAccountButton.addActionListener(e -> {
            if(e.getSource() == newAccountButton){
                frame.dispose();
                new CreateAccountFrame();
            }
        });
        newAccountPanel.add(newAccountButton);

        JPanel logoutPanel = new JPanel();
        logoutPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        logoutPanel.setBackground(Color.lightGray);
        logoutPanel.setPreferredSize(new Dimension(400, 50));
        JButton logoutButton = new JButton("Logout");
        logoutButton.setPreferredSize(new Dimension(380, 40));
        buttonEffects(logoutButton);
        logoutButton.addActionListener(e -> {
            if(e.getSource() == logoutButton){
                frame.dispose();
                new CreateOrLoginFrame();
            }
        });
        logoutPanel.add(logoutButton);

        frame.add(depositPanel);
        frame.add(sendPanel);
        frame.add(withDrawPanel);
        frame.add(balancePanel);
        frame.add(newAccountPanel);
        frame.add(logoutPanel);
        frame.setVisible(true);
    }
}
