package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;

public class CheckBalanceFrame {
    CheckBalanceFrame() {
        JFrame frame = new JFrame("Check Balance");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.green);


        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 150));
        JLabel label = new JLabel("Choose Account: ");
        panel.add(label);

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(500, 150));
        JButton button = new JButton("Account One");
        button.addActionListener(e -> {
            if(e.getSource() == button) {
//                frame.dispose();
             JOptionPane.showMessageDialog(null, "Account One Balance: 24543.97");
            }
        });


        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(500, 150));
        JButton button2 = new JButton("Account Two");
        button2.addActionListener(e -> {
            if(e.getSource() == button2) {
//                frame.dispose();
                JOptionPane.showMessageDialog(null, "Account Two Balance: 24676743.97");
            }
        });

        panel2.setLayout(new FlowLayout());
        panel2.setBackground(Color.green);
        panel.add(label);
        panel1.add(button);
        panel2.add(button2);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
