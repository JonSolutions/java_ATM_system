package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

import static josefDeEmpire.example.JdbcCrud.*;
import static josefDeEmpire.example.MyUtils.*;

public class DepositFrame {
    DepositFrame(){
        JFrame frame = new JFrame("Deposit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.cyan);


        JPanel depositAmountLabelPanel = new JPanel();
        depositAmountLabelPanel.setBackground(Color.cyan);
        depositAmountLabelPanel.setLayout(new FlowLayout());
        depositAmountLabelPanel.setPreferredSize(new Dimension(200, 30));
        JLabel depositAmountLabel = new JLabel("Deposit Amount");
        depositAmountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        depositAmountLabel.setPreferredSize(new Dimension(100, 30));
        depositAmountLabelPanel.add(depositAmountLabel);


        JPanel depositAmountFieldPanel = new JPanel();
        depositAmountFieldPanel.setBackground(Color.cyan);
        depositAmountFieldPanel.setLayout(new FlowLayout());
        depositAmountFieldPanel.setPreferredSize(new Dimension(280, 40));
        JTextField depositAmountTextField = new JTextField();
        depositAmountTextField.setFont(new Font("Arial", Font.BOLD, 20));
        depositAmountTextField.setPreferredSize(new Dimension(250, 30));
        textFieldEffects(depositAmountTextField, "Enter Deposit Amount");
        depositAmountTextField.setEditable(true);
        depositAmountFieldPanel.add(depositAmountTextField);

        JPanel depositFromPanel = new JPanel();
        depositFromPanel.setBackground(Color.cyan);
        depositFromPanel.setLayout(new FlowLayout());
        depositFromPanel.setPreferredSize(new Dimension(200, 30));
        JLabel depositFrom = new JLabel("Hi, " + currentUser_first_name + " " + currentUser_last_name + " happy transacting!!");
        depositFrom.setFont(new Font("Arial", Font.BOLD, 12));
        depositFrom.setPreferredSize(new Dimension(200, 30));
        depositFrom.setBackground(Color.cyan);
        depositFromPanel.add(depositFrom);


//        JPanel depositFromFieldPanel = new JPanel();
//        depositFromFieldPanel.setBackground(Color.cyan);
//        depositFromFieldPanel.setLayout(new FlowLayout());
//        depositFromFieldPanel.setPreferredSize(new Dimension(280, 40));
//        JTextField depositFromTextField = new JTextField();
//        depositFromTextField.setFont(new Font("Arial", Font.BOLD, 20));
//        depositFromTextField.setPreferredSize(new Dimension(250, 30));
//        depositFromTextField.setEditable(true);
//        depositFromTextField.setBackground(Color.cyan);
//        depositFromFieldPanel.add(depositFromTextField);

        JPanel depositAmountButtonPanel = new JPanel();
        depositAmountButtonPanel.setBackground(Color.cyan);
        depositAmountButtonPanel.setLayout(new FlowLayout());
        depositAmountButtonPanel.setPreferredSize(new Dimension(280, 40));
        JButton depositAmountButton = new JButton("Deposit +");
        depositAmountButton.setFont(new Font("Arial", Font.BOLD, 12));
        depositAmountButton.setPreferredSize(new Dimension(250, 30));
        depositAmountButton.setBackground(Color.green);
        buttonEffects(depositAmountButton);
        depositAmountButton.addActionListener(e -> {
            if(e.getSource() == depositAmountButton){
                if(!isSafeDouble(depositAmountTextField.getText())){
                    String y = "Invalid Amount!!!";
                    JOptionPane.showMessageDialog(frame, y, "Field Error", JOptionPane.ERROR_MESSAGE);
                    depositAmountTextField.setText("");
                }else{
                    if(depositAmountTextField.getText().isEmpty()){
                        String x = "Deposit amount is required!!!";
                        JOptionPane.showMessageDialog(frame, x, "Field Error", JOptionPane.ERROR_MESSAGE);
                    }else {
                        String message = "Initiating depositing of  ksh " + depositAmountTextField.getText() + " / = to your account number: " + currentUser_id;
                        int response = JOptionPane.showConfirmDialog(frame, message + " Do you want to continue?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
                        if (response == JOptionPane.OK_OPTION) {
//                        int user_id = Integer.parseUnsignedInt(depositFromTextField.getText());
                            double amount = Double.parseDouble(depositAmountTextField.getText());
                            if(deposits(currentUser_id, amount)){
                                String text = "ksh " + depositAmountTextField.getText() + " /= has been deposited to your account successfully!!: ";
                                JOptionPane.showMessageDialog(frame, text, "Transaction Completed!!", JOptionPane.PLAIN_MESSAGE);
                                frame.dispose();
                                new HomeFrame();
                            }
                        }
                    }
                }
            }
        });
        depositAmountButtonPanel.add(depositAmountButton);

        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.cyan);
        homePanel.setLayout(new FlowLayout());
        homePanel.setPreferredSize(new Dimension(280, 40));
        JButton homeButton = new JButton("Back To Main Menu");
        homeButton.setFont(new Font("Arial", Font.BOLD, 12));
        homeButton.setPreferredSize(new Dimension(250, 30));
        buttonEffects(homeButton);
        homeButton.addActionListener(e -> {
            if(e.getSource() == homeButton){
               frame.dispose();
               new HomeFrame();
            }
        });
        homePanel.add(homeButton);

        frame.add(depositFromPanel);
        frame.add(depositAmountLabelPanel);
        frame.add(depositAmountFieldPanel);
//        frame.add(depositFromFieldPanel);
        frame.add(depositAmountButtonPanel);
        frame.add(homePanel);
        frame.setVisible(true);
    }
}
