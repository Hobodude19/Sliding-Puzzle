package Graphics;

import java.awt.*;
import javax.swing.*;

public class Tile extends JComponent{
    int number;
    Color c;
    Tile(int number, Color c) {
        this.number = number;
        this.c = c;
        JLabel num = new JLabel(Integer.toString(number));
        this.add(num);
        num.setVisible(true);
    }
    public void paint(Graphics g){
        int side = 150;
        g.setColor(c);
        g.fillRect(10, 10, side, side);
//        g.fill
    }
}