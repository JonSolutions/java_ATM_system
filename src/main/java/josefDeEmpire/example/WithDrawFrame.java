package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

public class WithDrawFrame {
    WithDrawFrame(){
        JFrame frame = new JFrame("Withdraw Money");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 325);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.lightGray);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);


        JPanel withdrawPanel = new JPanel();
        withdrawPanel.setLayout(new FlowLayout());
        withdrawPanel.setPreferredSize(new Dimension(400, 30));
        JLabel withdrawLabel = new JLabel("Withdraw Amount");
        withdrawLabel.setPreferredSize(new Dimension(100, 20));
        withdrawPanel.add(withdrawLabel);


        JPanel withdrawAmountFieldPanel = new JPanel();
        withdrawAmountFieldPanel.setLayout(new FlowLayout());
        withdrawAmountFieldPanel.setPreferredSize(new Dimension(400, 40));
        JTextField withdrawAmountField = new JTextField();
        withdrawAmountField.setPreferredSize(new Dimension(380, 30));
        withdrawAmountField.setFont(new Font("Serif", Font.BOLD, 20));
        withdrawAmountFieldPanel.add(withdrawAmountField);

        JPanel withdrawToPanel = new JPanel();
        withdrawToPanel.setLayout(new FlowLayout());
        withdrawToPanel.setPreferredSize(new Dimension(400, 30));
        JLabel withdrawToLabel = new JLabel("Withdraw To");
        withdrawToLabel.setPreferredSize(new Dimension(100, 20));
        withdrawToPanel.add(withdrawToLabel);


        JPanel withdrawToFieldPanel = new JPanel();
        withdrawToFieldPanel.setLayout(new FlowLayout());
        withdrawToFieldPanel.setPreferredSize(new Dimension(400, 40));
        JTextField withdrawToField = new JTextField();
        withdrawToField.setPreferredSize(new Dimension(380, 30));
        withdrawToField.setFont(new Font("Serif", Font.BOLD, 20));
        withdrawToFieldPanel.add(withdrawToField);

        JPanel withdrawButtonPanel = new JPanel();
        withdrawButtonPanel.setLayout(new FlowLayout());
        withdrawButtonPanel.setPreferredSize(new Dimension(400, 70));
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setPreferredSize(new Dimension(380, 70));
        withdrawButton.setBackground(Color.green);
        MyUtils myUtils = new MyUtils();
        myUtils.buttonEffects(withdrawButton);
        withdrawButton.addActionListener(e -> {
            if(e.getSource() == withdrawButton) {
                if(withdrawAmountField.getText().isEmpty() || withdrawToField.getText().isEmpty()) {
                    String x = "All fields are required!!!";
                    JOptionPane.showMessageDialog(frame, x, "Field Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    String text = "Initiate withdraw of ksh " + withdrawAmountField.getText() + " /= To: " + withdrawToField.getText();
                    int response = JOptionPane.showConfirmDialog(frame, text + "Do you want to continue?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
                    if (response == JOptionPane.OK_OPTION) {
                        String message = "ksh " + withdrawAmountField.getText() + " /= has been withdrawn to: " + withdrawToField.getText();
                        JOptionPane.showMessageDialog(frame, message, "Transaction Complete!", JOptionPane.PLAIN_MESSAGE);
                        frame.dispose();
                        new HomeFrame();
                    }
                }
            }
        });
        withdrawButtonPanel.add(withdrawButton);

        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setPreferredSize(new Dimension(400, 40));
        JButton homeButton = new JButton("Back To Main Menu");
        homeButton.setPreferredSize(new Dimension(380, 30));
        homeButton.addActionListener(e -> {
        if(e.getSource() == homeButton) {
            frame.dispose();
            new HomeFrame();
        }
        });
        homePanel.add(homeButton);

        frame.add(withdrawPanel);
        frame.add(withdrawAmountFieldPanel);
        frame.add(withdrawToPanel);
        frame.add(withdrawToFieldPanel);
        frame.add(withdrawButtonPanel);
        frame.add(homePanel);
        frame.setVisible(true);
    }
}
