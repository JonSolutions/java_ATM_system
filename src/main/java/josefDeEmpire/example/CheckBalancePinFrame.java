package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

import static josefDeEmpire.example.JdbcCrud.*;
import static josefDeEmpire.example.MyUtils.buttonEffects;
import static josefDeEmpire.example.MyUtils.textFieldEffects;

public class CheckBalancePinFrame {
    CheckBalancePinFrame() {
        JFrame frame = new JFrame("Your Balance");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 275);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.cyan);


        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        JPanel labelPanel = new JPanel();
        labelPanel.setBackground(Color.cyan);
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(500, 40));
        JLabel label = new JLabel("Enter Username");
        label.setPreferredSize(new Dimension(100, 30));
//        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setForeground(Color.black);
        JPasswordField textField = new JPasswordField();
        textField.setPreferredSize(new Dimension(400, 30));
        textField.setFont(new Font("Serif", Font.PLAIN, 20));
        textFieldEffects(textField, "Enter Username");
        textField.setEditable(true);
        labelPanel.add(label);
        panel.add(textField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.cyan);
//        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonPanel.setPreferredSize(new Dimension(500, 60));
        buttonPanel.setLayout(new FlowLayout());
        JButton button = new JButton("Check Balance");
        button.setPreferredSize(new Dimension(500, 50));
        buttonEffects(button);
        buttonPanel.add(button);
        button.addActionListener(e -> {
            if(e.getSource() == button) {
                String username = String.valueOf(textField.getText());
//                String user = isUsername(username);

                    if(textField.getText().isEmpty()){
                        String empt = "Enter Username First!!";
                        JOptionPane.showMessageDialog(frame, empt,"Empty Username!!", JOptionPane.INFORMATION_MESSAGE);
                    }else if (!username.equals(currentUser_username)){
                        String mess = " Incorrect username!! Enter Valid Username";
                        JOptionPane.showMessageDialog(frame, mess, "Wrong username!!", JOptionPane.ERROR_MESSAGE);
                }else{
//                        int id = isUserId(username);
                        String total;
                        String first_name;
                        String last_name;
                        try {
                            List<MyUtils> userList = checkBalance(currentUser_id);
                            System.out.println(userList);
                            total = String.valueOf(userList.getFirst().total);
                            first_name = userList.getFirst().first_name;
                            last_name = userList.getFirst().last_name;
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(frame, "Hello, " + first_name + " " + last_name + ", Your balance is: " + total);
                        textField.setText("");
                        frame.dispose();
                        new HomeFrame();
                    }
            }

        });

        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.cyan);
//        homePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        homePanel.setPreferredSize(new Dimension(500, 60));
        homePanel.setLayout(new FlowLayout());
        JButton homeButton = new JButton("Back To Main Menu");
        homeButton.setPreferredSize(new Dimension(500, 50));
        buttonEffects(homeButton);
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
