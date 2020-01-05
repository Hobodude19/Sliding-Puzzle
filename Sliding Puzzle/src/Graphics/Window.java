package Graphics;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame;

    public Window() {
        frame = new JFrame("Sliding Puzzle");

        frame.setBackground(Color.BLACK);
        frame.setSize(1200,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showFrame();
    }

    private void showFrame() {
        frame.setVisible(true);
    }
}
