package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

public class HomeFrame {
    HomeFrame(){
        JFrame frame = new JFrame("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 330);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().setBackground(Color.cyan);

        JLabel label = new JLabel("Home Main Menu");
        frame.add(label);

        JPanel depositPanel = new JPanel();
        depositPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        depositPanel.setBackground(Color.lightGray);
        depositPanel.setPreferredSize(new Dimension(400, 50));
        JButton depositButton = new JButton("Deposit");
        depositButton.setPreferredSize(new Dimension(380, 40));
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
        newAccountButton.addActionListener(e -> {
            if(e.getSource() == newAccountButton){
                frame.dispose();
                new CreateAccountFrame();
            }
        });
        newAccountPanel.add(newAccountButton);

        frame.add(depositPanel);
        frame.add(sendPanel);
        frame.add(withDrawPanel);
        frame.add(balancePanel);
        frame.add(newAccountPanel);
        frame.setVisible(true);
    }
}
