package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyUtils {
    double total;
    String first_name;
    String last_name;
    String username;
    boolean isSuccessful;
    MyUtils(double total, String first_name, String last_name, String username, boolean isSuccessful) {
        this.total = total;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.isSuccessful = isSuccessful;
    }
    public static void buttonEffects(JButton btn){
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                btn.setBackground(Color.blue);
                btn.setForeground(Color.magenta);
                btn.setFont(new Font("Tahoma", Font.BOLD, 16));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                btn.setForeground(Color.black);
                btn.setBackground(Color.green);
                btn.setFont(new Font("Tahoma", Font.BOLD, 15));
            }
            @Override
            public void mouseEntered(MouseEvent e){
                btn.setForeground(Color.blue);
                btn.setFont(new Font("Tahoma", Font.BOLD, 15));
            }
            @Override
            public void mouseExited(MouseEvent e){
                btn.setForeground(Color.black);
                btn.setFont(new Font("Tahoma", Font.BOLD, 13));
            }
        });
    }

    public static void textFieldEffects(JTextField txt, String labelName){
        txt.setCaretColor(new Color(5, 96, 255));
        txt.setSelectionColor(Color.cyan);
        txt.setBackground(new Color(1, 255, 208));
        txt.setToolTipText(labelName);
        txt.setHorizontalAlignment(JTextField.CENTER);
        txt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                txt.setBackground(new Color(2, 205, 164));
                txt.requestFocusInWindow();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                txt.setBackground(new Color(1, 255, 208));
            }
        });
    }
}

