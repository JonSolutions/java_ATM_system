package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyUtils {
    String total;
    String first_name;
    String last_name;
    String username;
    MyUtils(double total, String first_name, String last_name, String username) {
        this.total = String.valueOf(total);
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
    }
    public static void buttonEffects(JButton btn){
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                btn.setBackground(Color.blue);
                btn.setForeground(Color.green);
                btn.setFont(new Font("Tahoma", Font.BOLD, 16));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                btn.setBackground(Color.gray);
                btn.setForeground(Color.black);
                btn.setFont(new Font("Tahoma", Font.BOLD, 15));
            }
            @Override
            public void mouseEntered(MouseEvent e){
                btn.setForeground(Color.black);
                btn.setFont(new Font("Tahoma", Font.BOLD, 15));
            }
            @Override
            public void mouseExited(MouseEvent e){
                btn.setForeground(Color.blue);
                btn.setFont(new Font("Tahoma", Font.BOLD, 13));
            }
        });
    }
}

