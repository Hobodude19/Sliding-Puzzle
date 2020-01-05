package Graphics;

import Logic.Music;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame;
    JPanel inner;
    Music m;

    public Window() {
        
        inner = new JPanel();
        inner.setPreferredSize(new Dimension(800,800));
        inner.setBackground(new Color(56,52,55));
        inner.setVisible(true);
        
        frame = new JFrame("Sliding Puzzle");

        frame.getContentPane().setBackground(new Color(75,79,87));
        frame.setSize(1200,900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        frame.add(inner);
        
        
        m = new Music();
        m.startMusic();

        showFrame();
    }

    private void showFrame() {
        frame.setVisible(true);
    }
}
