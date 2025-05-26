package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static josefDeEmpire.example.JdbcCrud.*;
import static josefDeEmpire.example.MyUtils.*;

public class SendMoneyFrame {
    SendMoneyFrame (){
        JFrame frame = new JFrame("Send Money");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 420);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);


        JPanel sendAmountPanel = new JPanel();
        sendAmountPanel.setBackground(Color.cyan);
        sendAmountPanel.setLayout(new FlowLayout());
        sendAmountPanel.setPreferredSize(new Dimension(400, 30));
        JLabel sendAmountLabel = new JLabel("Send Amount");
        sendAmountLabel.setPreferredSize(new Dimension(100, 20));
        sendAmountPanel.add(sendAmountLabel);


        JPanel amountFieldPanel = new JPanel();
        amountFieldPanel.setBackground(Color.cyan);
        amountFieldPanel.setLayout(new FlowLayout());
        amountFieldPanel.setPreferredSize(new Dimension(400, 40));
        JTextField sendAmountField = new JTextField();
        sendAmountField.setPreferredSize(new Dimension(380, 30));
        sendAmountField.setFont(new Font("Serif", Font.BOLD, 20));
        textFieldEffects(sendAmountField, "Enter Send Amount");
        amountFieldPanel.add(sendAmountField);

        JPanel sendFromPanel = new JPanel();
        sendFromPanel.setBackground(Color.cyan);
        sendFromPanel.setLayout(new FlowLayout());
        sendFromPanel.setPreferredSize(new Dimension(400, 30));
        JLabel sendFromLabel = new JLabel("Hi, " + currentUser_first_name + " " + currentUser_last_name + " happy transacting!!");
        sendFromLabel.setPreferredSize(new Dimension(200, 20));
        sendFromPanel.add(sendFromLabel);


        JPanel sendToPanel = new JPanel();
        sendToPanel.setBackground(Color.cyan);
        sendToPanel.setLayout(new FlowLayout());
        sendToPanel.setPreferredSize(new Dimension(400, 30));
        JLabel sendToLabel = new JLabel("To Account Number");
        sendToLabel.setPreferredSize(new Dimension(100, 20));
        sendToPanel.add(sendToLabel);


        JPanel sendFieldPanel = new JPanel();
        sendFieldPanel.setBackground(Color.cyan);
        sendFieldPanel.setLayout(new FlowLayout());
        sendFieldPanel.setPreferredSize(new Dimension(400, 40));
        JTextField sendToField = new JTextField();
        sendToField.setPreferredSize(new Dimension(380, 30));
        sendToField.setFont(new Font("Serif", Font.BOLD, 20));
        textFieldEffects(sendToField, "Enter Account Number");
        sendFieldPanel.add(sendToField);

        JPanel sendButtonPanel = new JPanel();
        sendButtonPanel.setBackground(Color.cyan);
        sendButtonPanel.setLayout(new FlowLayout());
        sendButtonPanel.setPreferredSize(new Dimension(400, 70));
        JButton sendButton = new JButton("Send");
        sendButton.setPreferredSize(new Dimension(380, 70));
        sendButton.setBackground(Color.green);
        buttonEffects(sendButton);
        sendButton.addActionListener(e -> {
            if(e.getSource() == sendButton) {
                if(!isSafeDouble(sendAmountField.getText())){
                    String y = "Invalid Amount!!!";
                    JOptionPane.showMessageDialog(frame, y, "Field Error", JOptionPane.ERROR_MESSAGE);
                    sendAmountField.setText("");
                }else {

                    if (sendAmountField.getText().isEmpty() || sendToField.getText().isEmpty()) {
                        String x = "All fields are required!!!";
                        JOptionPane.showMessageDialog(frame, x, "Field Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if(!isSafeInt(sendToField.getText())) {
                            String n = "Invalid Account Number!!!";
                            JOptionPane.showMessageDialog(frame, n, "Field Error", JOptionPane.ERROR_MESSAGE);
                            sendToField.setText("");
                        }else{
                            int recipient_id = Integer.parseInt(sendToField.getText());
                            if (recipient_id == currentUser_id) {
                                JOptionPane.showMessageDialog(frame, "Invalid Account Number!!", "Account Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                double balance;
                                boolean isSuccessful;
                                try {
                                    balance = checkBalance(currentUser_id).getFirst().total;
                                    isSuccessful = checkBalance(currentUser_id).getFirst().isSuccessful;
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                                double amount = Double.parseDouble(sendAmountField.getText());
                                if (amount > balance) {
                                    JOptionPane.showMessageDialog(frame, "Failed!! You have Insufficient Funds! Current balance is: ksh " + String.valueOf(balance) + " /=", "Insufficient Funds", JOptionPane.ERROR_MESSAGE);
                                } else if (sendAmountField.getText().length() > 8) {
                                    JOptionPane.showMessageDialog(frame, "Invalid Amount!!", "Amount Error", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    String first_name = userNames(recipient_id).get(0);
                                    String last_name = userNames(recipient_id).get(1);
                                    String message = "Initiating Sending of  ksh " + sendAmountField.getText() + " / = to " + first_name + " " + last_name + ", Account Number: " + sendToField.getText();
                                    int response = JOptionPane.showConfirmDialog(frame, message + ".  Do you want to continue?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
                                    if (response == JOptionPane.OK_OPTION) {
                                        //                        int user_id = Integer.parseInt(sendFroField.getText());

                                        if (sends(currentUser_id, recipient_id, amount)) {
                                            try {
                                                balance = checkBalance(currentUser_id).getFirst().total;
                                                isSuccessful = checkBalance(currentUser_id).getFirst().isSuccessful;
                                            } catch (SQLException ex) {
                                                throw new RuntimeException(ex);
                                            }
                                            String text = "Confirmed ksh " + sendAmountField.getText() + " /= has been sent to " + first_name + " " + last_name + ", Account Number:  " + sendToField.getText() + ". Your New Account Balance is: ksh " + String.valueOf(balance) + " /=";
                                            if (isSuccessful) {
                                                JOptionPane.showMessageDialog(frame, text, "Transaction Completed!!", JOptionPane.PLAIN_MESSAGE);
                                                frame.dispose();
                                                new HomeFrame();
                                            } else {
                                                String txt2 = "Confirmed ksh " + sendAmountField.getText() + " /= has been sent to " + first_name + " " + last_name + ", Account Number:  " + sendToField.getText();
                                                JOptionPane.showMessageDialog(frame, txt2, "Transaction Completed!!", JOptionPane.PLAIN_MESSAGE);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }

            }
        });
        sendButtonPanel.add(sendButton);

        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setBackground(Color.cyan);
        homeButtonPanel.setLayout(new FlowLayout());
        homeButtonPanel.setPreferredSize(new Dimension(400, 40));
        JButton homeButton = new JButton("Back To Main Menu");
        homeButton.setPreferredSize(new Dimension(380, 30));
        buttonEffects(homeButton);
        homeButton.addActionListener(e -> {
        if (e.getSource() == homeButton) {
            frame.dispose();
            new HomeFrame();
        }
        });
        homeButtonPanel.add(homeButton);

        frame.add(sendFromPanel);
        frame.add(sendAmountPanel);
        frame.add(amountFieldPanel);
        frame.add(sendToPanel);
        frame.add(sendFieldPanel);
        frame.add(sendButtonPanel);
        frame.add(homeButtonPanel);
        frame.setVisible(true);
    }
}
