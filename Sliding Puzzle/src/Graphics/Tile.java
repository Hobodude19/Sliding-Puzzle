package Graphics;

import java.awt.*;
import javax.swing.*;

public class Tile extends JComponent{
    int number;
    int x;
    int y;
    Color c;
    Tile(int number, int x, int y, Color c) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.c = c;
        JLabel num = new JLabel(Integer.toString(number));
        this.add(num);
        num.setVisible(true);
    }
    public void paint(Graphics g){
        int side = 150;
        g.setColor(c);
        g.fillRect(x, y, side, side);
    }
}