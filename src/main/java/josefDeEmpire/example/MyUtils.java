package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyUtils {
    MyUtils() {}
    public void buttonEffects(JButton btn){
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
