package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

import static josefDeEmpire.example.MyUtils.buttonEffects;

public class CheckBalanceFrame {
    CheckBalanceFrame() {
        JFrame frame = new JFrame("Check Balance");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 210);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.cyan);


        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        panel.setPreferredSize(new Dimension(300, 40));
        JLabel label = new JLabel("Choose Account: ");


        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.cyan);
        panel1.setPreferredSize(new Dimension(300, 60));
        JButton button = new JButton("Account One");
        button.setPreferredSize(new Dimension(280, 50));
        buttonEffects(button);
        button.addActionListener(e -> {
            if(e.getSource() == button) {
                frame.dispose();
                new CheckBalancePinFrame();
//        JOptionPane.showMessageDialog(null, "Account One Balance: 24543.97");
            }
        });


        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.cyan);
        panel2.setPreferredSize(new Dimension(300, 60));
        JButton button2 = new JButton("Account Two");
        button2.setPreferredSize(new Dimension(280, 50));
        buttonEffects(button2);
        button2.addActionListener(e -> {
            if(e.getSource() == button2) {
                frame.dispose();
                new CheckBalancePinFrame();
//                JOptionPane.showMessageDialog(null, "Account Two Balance: 24676743.97");
            }
        });

        panel2.setLayout(new FlowLayout());
        panel.add(label);
        panel1.add(button);
        panel2.add(button2);
        frame.add(panel);
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
    }
}
