package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

import static josefDeEmpire.example.JdbcCrud.sends;

public class SendMoneyFrame {
    SendMoneyFrame (){
        JFrame frame = new JFrame("Send Money");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 420);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.lightGray);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);


        JPanel sendAmountPanel = new JPanel();
        sendAmountPanel.setLayout(new FlowLayout());
        sendAmountPanel.setPreferredSize(new Dimension(400, 30));
        JLabel sendAmountLabel = new JLabel("Send Amount");
        sendAmountLabel.setPreferredSize(new Dimension(100, 20));
        sendAmountPanel.add(sendAmountLabel);


        JPanel amountFieldPanel = new JPanel();
        amountFieldPanel.setLayout(new FlowLayout());
        amountFieldPanel.setPreferredSize(new Dimension(400, 40));
        JTextField sendAmountField = new JTextField();
        sendAmountField.setPreferredSize(new Dimension(380, 30));
        sendAmountField.setFont(new Font("Serif", Font.BOLD, 20));
        amountFieldPanel.add(sendAmountField);

        JPanel sendFromPanel = new JPanel();
        sendFromPanel.setLayout(new FlowLayout());
        sendFromPanel.setPreferredSize(new Dimension(400, 30));
        JLabel sendFromLabel = new JLabel("Send From Account");
        sendFromLabel.setPreferredSize(new Dimension(100, 20));
        sendFromPanel.add(sendFromLabel);


        JPanel sendFroPanel = new JPanel();
        sendFroPanel.setLayout(new FlowLayout());
        sendFroPanel.setPreferredSize(new Dimension(400, 40));
        JTextField sendFroField = new JTextField();
        sendFroField.setPreferredSize(new Dimension(380, 30));
        sendFroField.setFont(new Font("Serif", Font.BOLD, 20));
        sendFroPanel.add(sendFroField);

        JPanel sendToPanel = new JPanel();
        sendToPanel.setLayout(new FlowLayout());
        sendToPanel.setPreferredSize(new Dimension(400, 30));
        JLabel sendToLabel = new JLabel("Send To Account");
        sendToLabel.setPreferredSize(new Dimension(100, 20));
        sendToPanel.add(sendToLabel);


        JPanel sendFieldPanel = new JPanel();
        sendFieldPanel.setLayout(new FlowLayout());
        sendFieldPanel.setPreferredSize(new Dimension(400, 40));
        JTextField sendToField = new JTextField();
        sendToField.setPreferredSize(new Dimension(380, 30));
        sendFieldPanel.add(sendToField);

        JPanel sendButtonPanel = new JPanel();
        sendButtonPanel.setLayout(new FlowLayout());
        sendButtonPanel.setPreferredSize(new Dimension(400, 70));
        JButton sendButton = new JButton("Send");
        sendButton.setPreferredSize(new Dimension(380, 70));
        sendButton.setBackground(Color.green);
        MyUtils myUtils = new MyUtils();
        myUtils.buttonEffects(sendButton);
        sendButton.addActionListener(e -> {
            if(e.getSource() == sendButton) {
                if (sendAmountField.getText().isEmpty() || sendToField.getText().isEmpty()) {
                    String x = "All fields are required!!!";
                    JOptionPane.showMessageDialog(frame, x, "Field Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String message = "Initiating Sending of  ksh " + sendAmountField.getText() + " / = To: " + sendToField.getText();
                    int response = JOptionPane.showConfirmDialog(frame, message + " Do you want to continue?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
                    if (response == JOptionPane.OK_OPTION) {
                        int user_id = Integer.parseInt(sendFroField.getText());
                        int recipient_id = Integer.parseInt(sendToField.getText());
                        double amount = Double.parseDouble(sendAmountField.getText());
                        sends(user_id, recipient_id, amount);
                        String text = "ksh " + sendAmountField.getText() + " /= has been sent to: " + sendToField.getText();
                        JOptionPane.showMessageDialog(frame, text, "Transaction Completed!!", JOptionPane.PLAIN_MESSAGE);
                        frame.dispose();
                        new HomeFrame();
                    }
                }

            }
        });
        sendButtonPanel.add(sendButton);

        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new FlowLayout());
        homeButtonPanel.setPreferredSize(new Dimension(400, 40));
        JButton homeButton = new JButton("Back To Main Menu");
        homeButton.setPreferredSize(new Dimension(380, 30));
        homeButton.addActionListener(e -> {
        if (e.getSource() == homeButton) {
            frame.dispose();
            new HomeFrame();
        }
        });
        homeButtonPanel.add(homeButton);

        frame.add(sendAmountPanel);
        frame.add(amountFieldPanel);
        frame.add(sendToPanel);
        frame.add(sendFieldPanel);
        frame.add(sendFromPanel);
        frame.add(sendFroPanel);
        frame.add(sendButtonPanel);
        frame.add(homeButtonPanel);
        frame.setVisible(true);
    }
}
