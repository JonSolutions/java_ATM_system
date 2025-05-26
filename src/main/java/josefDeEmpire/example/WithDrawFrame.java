package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static josefDeEmpire.example.JdbcCrud.*;
import static josefDeEmpire.example.MyUtils.buttonEffects;
import static josefDeEmpire.example.MyUtils.textFieldEffects;

public class WithDrawFrame {
    WithDrawFrame(){
        JFrame frame = new JFrame("Withdraw Money");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 325);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);


        JPanel withdrawPanel = new JPanel();
        withdrawPanel.setBackground(Color.cyan);
        withdrawPanel.setLayout(new FlowLayout());
        withdrawPanel.setPreferredSize(new Dimension(400, 30));
        JLabel withdrawLabel = new JLabel("Withdraw Amount");
        withdrawLabel.setPreferredSize(new Dimension(100, 20));
        withdrawPanel.add(withdrawLabel);


        JPanel withdrawAmountFieldPanel = new JPanel();
        withdrawAmountFieldPanel.setBackground(Color.cyan);
        withdrawAmountFieldPanel.setLayout(new FlowLayout());
        withdrawAmountFieldPanel.setPreferredSize(new Dimension(400, 40));
        JTextField withdrawAmountField = new JTextField();
        withdrawAmountField.setPreferredSize(new Dimension(380, 30));
        withdrawAmountField.setFont(new Font("Serif", Font.BOLD, 20));
        textFieldEffects(withdrawAmountField, "Enter Withdraw Amount");
        withdrawAmountFieldPanel.add(withdrawAmountField);

        JPanel withdrawToPanel = new JPanel();
        withdrawToPanel.setBackground(Color.cyan);
        withdrawToPanel.setLayout(new FlowLayout());
        withdrawToPanel.setPreferredSize(new Dimension(400, 30));
        JLabel withdrawToLabel = new JLabel("Hello, " + currentUser_first_name + " " + currentUser_last_name + " Happy transacting!!");
        withdrawToLabel.setPreferredSize(new Dimension(250, 20));
        withdrawToPanel.add(withdrawToLabel);


        JPanel withdrawButtonPanel = new JPanel();
        withdrawButtonPanel.setBackground(Color.cyan);
        withdrawButtonPanel.setLayout(new FlowLayout());
        withdrawButtonPanel.setPreferredSize(new Dimension(400, 70));
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setPreferredSize(new Dimension(380, 70));
        withdrawButton.setBackground(Color.green);
        buttonEffects(withdrawButton);
        withdrawButton.addActionListener(e -> {
            if(e.getSource() == withdrawButton) {
                if(withdrawAmountField.getText().isEmpty()) {
                    String x = "Withdraw amount is required!!!";
                    JOptionPane.showMessageDialog(frame, x, "Field Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    double balance;
                    try {
                        balance = checkBalance(currentUser_id).getFirst().total;
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if(Double.parseDouble(withdrawAmountField.getText()) > balance) {
                        JOptionPane.showMessageDialog(frame, "Withdraw amount exceeds the balance!! Your current balance is " + String.valueOf(balance), "Amount Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        String text = "Initiate withdraw of ksh " + withdrawAmountField.getText() + " /= from your account number: " + currentUser_id;
                        int response = JOptionPane.showConfirmDialog(frame, text + " Do you want to continue?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
                        if (response == JOptionPane.OK_OPTION) {

                            double amount = Double.parseDouble(withdrawAmountField.getText());
                            if(withdraws(currentUser_id, amount)){
                                String message = "ksh " + withdrawAmountField.getText() + " /= has been withdrawn from your account sucessfully!!!";
                                JOptionPane.showMessageDialog(frame, message, "Transaction Complete!", JOptionPane.PLAIN_MESSAGE);
                                frame.dispose();
                                new HomeFrame();
                            }
                        }
                    }
                }
            }
        });
        withdrawButtonPanel.add(withdrawButton);

        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.cyan);
        homePanel.setLayout(new FlowLayout());
        homePanel.setPreferredSize(new Dimension(400, 40));
        JButton homeButton = new JButton("Back To Main Menu");
        homeButton.setPreferredSize(new Dimension(380, 30));
        buttonEffects(homeButton);
        homeButton.addActionListener(e -> {
        if(e.getSource() == homeButton) {
            frame.dispose();
            new HomeFrame();
        }
        });
        homePanel.add(homeButton);

        frame.add(withdrawToPanel);
        frame.add(withdrawPanel);
        frame.add(withdrawAmountFieldPanel);
        frame.add(withdrawButtonPanel);
        frame.add(homePanel);
        frame.setVisible(true);
    }
}
