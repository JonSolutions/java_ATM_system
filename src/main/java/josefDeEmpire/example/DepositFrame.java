package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

import static josefDeEmpire.example.JdbcCrud.deposits;
import static josefDeEmpire.example.JdbcCrud.sends;
import static josefDeEmpire.example.MyUtils.buttonEffects;

public class DepositFrame {
    DepositFrame(){
        JFrame frame = new JFrame("Deposit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());


        JPanel depositAmountLabelPanel = new JPanel();
        depositAmountLabelPanel.setLayout(new FlowLayout());
        depositAmountLabelPanel.setPreferredSize(new Dimension(200, 30));
        JLabel depositAmountLabel = new JLabel("Deposit Amount");
        depositAmountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        depositAmountLabel.setPreferredSize(new Dimension(100, 30));
        depositAmountLabelPanel.add(depositAmountLabel);


        JPanel depositAmountFieldPanel = new JPanel();
        depositAmountFieldPanel.setLayout(new FlowLayout());
        depositAmountFieldPanel.setPreferredSize(new Dimension(200, 30));
        JTextField depositAmountTextField = new JTextField();
        depositAmountTextField.setFont(new Font("Arial", Font.BOLD, 20));
        depositAmountTextField.setPreferredSize(new Dimension(180, 30));
        depositAmountTextField.setEditable(true);
        depositAmountFieldPanel.add(depositAmountTextField);

        JPanel depositFromPanel = new JPanel();
        depositFromPanel.setLayout(new FlowLayout());
        depositFromPanel.setPreferredSize(new Dimension(200, 30));
        JLabel depositFrom = new JLabel("From Account");
        depositFrom.setFont(new Font("Arial", Font.BOLD, 12));
        depositFrom.setPreferredSize(new Dimension(100, 30));
        depositFromPanel.add(depositFrom);


        JPanel depositFromFieldPanel = new JPanel();
        depositFromFieldPanel.setLayout(new FlowLayout());
        depositFromFieldPanel.setPreferredSize(new Dimension(200, 30));
        JTextField depositFromTextField = new JTextField();
        depositFromTextField.setFont(new Font("Arial", Font.BOLD, 20));
        depositFromTextField.setPreferredSize(new Dimension(180, 30));
        depositFromTextField.setEditable(true);
        depositFromFieldPanel.add(depositFromTextField);

        JPanel depositAmountButtonPanel = new JPanel();
        depositAmountButtonPanel.setLayout(new FlowLayout());
        depositAmountButtonPanel.setPreferredSize(new Dimension(200, 30));
        JButton depositAmountButton = new JButton("Deposit +");
        depositAmountButton.setFont(new Font("Arial", Font.BOLD, 12));
        depositAmountButton.setPreferredSize(new Dimension(180, 30));
        depositAmountButton.setBackground(Color.green);
        buttonEffects(depositAmountButton);
        depositAmountButton.addActionListener(e -> {
            if(e.getSource() == depositAmountButton){
                if(depositAmountTextField.getText().isEmpty() || depositFromTextField.getText().isEmpty()){
                    String x = "All fields are required!!!";
                    JOptionPane.showMessageDialog(frame, x, "Field Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    String message = "Initiating depositing of  ksh " + depositAmountTextField.getText() + " / = to your account from " + depositFromTextField.getText();
                    int response = JOptionPane.showConfirmDialog(frame, message + "Do you want to continue?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
                    if (response == JOptionPane.OK_OPTION) {
                        int user = Integer.parseUnsignedInt(depositFromTextField.getText());
                        double amount = Double.parseDouble(depositAmountTextField.getText());
                        deposits(user,amount);
                        String text = "ksh " + depositAmountTextField.getText() + " /= has been deposited to your account successfully!!: ";
                        JOptionPane.showMessageDialog(frame, text, "Transaction Completed!!", JOptionPane.PLAIN_MESSAGE);
                        frame.dispose();
                        new HomeFrame();
                    }
                }
            }
        });
        depositAmountButtonPanel.add(depositAmountButton);

        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setPreferredSize(new Dimension(200, 30));
        JButton homeButton = new JButton("Back To Main Menu");
        homeButton.setFont(new Font("Arial", Font.BOLD, 12));
        homeButton.setPreferredSize(new Dimension(180, 30));
        homeButton.addActionListener(e -> {
            if(e.getSource() == homeButton){
               frame.dispose();
               new HomeFrame();
            }
        });
        homePanel.add(homeButton);

        frame.add(depositAmountLabelPanel);
        frame.add(depositAmountFieldPanel);
        frame.add(depositFromPanel);
        frame.add(depositFromFieldPanel);
        frame.add(depositAmountButtonPanel);
        frame.add(homePanel);
        frame.setVisible(true);
    }
}
