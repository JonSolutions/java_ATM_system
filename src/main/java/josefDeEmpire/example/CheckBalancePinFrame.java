package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

public class CheckBalancePinFrame {
    CheckBalancePinFrame() {
        JFrame frame = new JFrame("Your Balance");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Password: ");
        label.setForeground(Color.red);
        JTextField textField = new JTextField(10);
        textField.setPreferredSize(new Dimension(300, 30));
        textField.setEditable(true);
        panel.add(label);
        panel.add(textField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(500, 30));
        buttonPanel.setBackground(Color.yellow);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.yellow);
        JButton button = new JButton("Check Balance");
        buttonPanel.add(button);
        button.addActionListener(e -> {
            if(e.getSource() == button) {
                if (textField.getText().equals("admin")) {
                    JOptionPane.showMessageDialog(frame, "Your balance is 100000.98");
                }
            }

        });
        frame.add(panel);
        frame.add(buttonPanel);
        frame.setVisible(true);
    }
}
