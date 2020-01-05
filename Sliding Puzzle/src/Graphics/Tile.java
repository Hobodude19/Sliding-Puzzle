package Graphics;

import java.awt.*;
import javax.swing.*;

public class Tile extends JComponent{
    int number;
    int x;
    int y;
    JTextArea txt;

    Color c;
    Tile(int number, int x, int y, Color c) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.c = c;

        JLabel num = new JLabel(Integer.toString(number));
        this.add(num);
        num.setVisible(true);

        txt = new JTextArea(String.valueOf(number));
        txt.setFont(txt.getFont().deriveFont(32f));
        txt.setEditable(false);
        txt.setSize(32,32);
    }
    public void paint(Graphics g){
        int side = 150;
        g.setColor(c);
        g.fillRect(x, y, side, side);
        txt.setLocation(75,75);
//        g.fill
    }
}