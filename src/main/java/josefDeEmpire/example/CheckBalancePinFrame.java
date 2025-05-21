package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

public class CheckBalancePinFrame {
    CheckBalancePinFrame() {
        JFrame frame = new JFrame("Your Balance");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 275);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        JPanel labelPanel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(500, 40));
        JLabel label = new JLabel("Enter Password");
        label.setPreferredSize(new Dimension(100, 30));
//        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setForeground(Color.red);
        JPasswordField textField = new JPasswordField();
        textField.setPreferredSize(new Dimension(400, 30));
        textField.setFont(new Font("Serif", Font.PLAIN, 20));
        textField.setEditable(true);
        labelPanel.add(label);
        panel.add(textField);

        JPanel buttonPanel = new JPanel();
//        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonPanel.setPreferredSize(new Dimension(500, 60));
        buttonPanel.setLayout(new FlowLayout());
        JButton button = new JButton("Check Balance");
        button.setPreferredSize(new Dimension(500, 50));
        buttonPanel.add(button);
        button.addActionListener(e -> {
            if(e.getSource() == button) {
                if (!(textField.getText().equals("admin"))){
                    if(textField.getText().isEmpty()){
                        String empt = "Enter Password First!!";
                        JOptionPane.showMessageDialog(frame, empt,"Empty Password!!", JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        String mess = " Incorrect password!! Enter Valid Password";
                        JOptionPane.showMessageDialog(frame, mess, "Wrong password!!", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "Your balance is 100000.98");
                    textField.setText("");
                    frame.dispose();
                    new HomeFrame();
                }
            }

        });

        JPanel homePanel = new JPanel();
//        homePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        homePanel.setPreferredSize(new Dimension(500, 60));
        homePanel.setLayout(new FlowLayout());
        JButton homeButton = new JButton("Back To Main Menu");
        homeButton.setPreferredSize(new Dimension(500, 50));
        homePanel.add(homeButton);
        homeButton.addActionListener(e -> {
            if(e.getSource() == homeButton) {
                frame.dispose();
                new HomeFrame();
            }

        });

        frame.add(labelPanel);
        frame.add(panel);
        frame.add(buttonPanel);
        frame.add(homePanel);
        frame.setVisible(true);
    }
}
