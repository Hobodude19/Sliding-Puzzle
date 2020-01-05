package Graphics;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame;

    public Window() {
        frame = new JFrame("Sliding Puzzle");

        frame.getContentPane().setBackground(new Color(56,52,55));
        frame.setSize(1200,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        showFrame();
    }

    private void showFrame() {
        frame.setVisible(true);
    }
}
