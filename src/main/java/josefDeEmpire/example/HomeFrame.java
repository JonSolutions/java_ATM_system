package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

public class HomeFrame {
    HomeFrame(){
        JFrame frame = new JFrame("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().setBackground(Color.cyan);

        JPanel depositPanel = new JPanel();
        depositPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        depositPanel.setBackground(Color.lightGray);
        depositPanel.setPreferredSize(new Dimension(400, 100));
        JButton depositButton = new JButton("Deposit");
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
        balancePanel.setPreferredSize(new Dimension(400, 100));
        JButton balanceButton = new JButton("Check Balance");
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
        sendPanel.setPreferredSize(new Dimension(400, 100));
        JButton sendButton = new JButton("Send Money");
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
        withDrawPanel.setPreferredSize(new Dimension(400, 100));
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            if(e.getSource() == withdrawButton){
                frame.dispose();
                new WithDrawFrame();
            }
        });
        withDrawPanel.add(withdrawButton);

        frame.add(depositPanel);
        frame.add(balancePanel);
        frame.add(sendPanel);
        frame.add(withDrawPanel);
        frame.setVisible(true);
    }
}
