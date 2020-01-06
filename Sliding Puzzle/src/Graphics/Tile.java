package Graphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tile extends JPanel{
    int number;
    JLabel label;
    Color c;

    Tile(int number) {
        this.number = number;
        this.setLayout(new GridBagLayout());

        label = new JLabel(Integer.toString(number));
        label.setFont(label.getFont().deriveFont(100f));
        this.add(label);
    }
}