package Graphics;

import Logic.Music;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame;
    Music m;

    public Window() {
        frame = new JFrame("Sliding Puzzle");

        frame.getContentPane().setBackground(new Color(56,52,55));
        frame.setSize(1200,900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        m = new Music();
        m.startMusic();

        showFrame();
    }

    private void showFrame() {
        frame.setVisible(true);
    }
}
