package Graphics;

import java.awt.*;
import javax.swing.*;

public class Tile extends JPanel{
    int number;
    JLabel label;
    Color c;
    private boolean isBorder = false;

    Tile(int number) {
        this.number = number;
        this.setLayout(new GridBagLayout());

        label = new JLabel(Integer.toString(number));
        label.setFont(label.getFont().deriveFont(100f));
        this.add(label);
    }

    public void toggleBorder() {
        if(isBorder) {
            isBorder = false;
            this.setBorder(null);
        }
        else {
            isBorder = true;
            this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        }
    }

    public boolean isBorder() {
        return isBorder;
    }
}
