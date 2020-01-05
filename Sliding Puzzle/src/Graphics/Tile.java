package Graphics;

import java.awt.*;
import javax.swing.*;

public class Tile extends JComponent{
    int number;
    int x;
    int y;
    Color c;
    JLabel label;
    Tile(int number, int x, int y, Color c) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.c = c;
        label = new JLabel(Integer.toString(number));
        label.setFont(label.getFont().deriveFont(100f));
        this.add(label);
    }
    public void paint(Graphics g){
        int side = 150;
        g.setColor(c);
        g.fillRect(x, y, side, side);
    }
}