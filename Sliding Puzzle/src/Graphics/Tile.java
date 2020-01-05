package Graphics;

import java.awt.*;
import javax.swing.*;

public class Tile extends JComponent{
    int number;
    JTextArea txt;
    Color c;
    Tile(int number, Color c) {
        this.number = number;
        this.c = c;
        txt = new JTextArea(String.valueOf(number));
        txt.setFont(txt.getFont().deriveFont(32f));
        txt.setEditable(false);
        txt.setSize(32,32);
    }
    public void paint(Graphics g){
        int side = 150;
        g.setColor(c);
        g.fillRect(10, 10, side, side);
        txt.setLocation(75,75);
//        g.fill
    }
}