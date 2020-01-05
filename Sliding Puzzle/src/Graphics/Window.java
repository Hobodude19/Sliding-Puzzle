package Graphics;

import Logic.Music;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame;
    JPanel panel;
    int panelWidth = 800;
    int panelHeight = 800;
    Music m;

    public Window() {
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(panelWidth,panelHeight));
        panel.setBackground(new Color(56,52,55));
//        
        frame = new JFrame("Sliding Puzzle");
        
        frame.getContentPane().setBackground(new Color(75,79,87));
        frame.setSize(1200,900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        frame.add(panel);
        
        Tile tile = new Tile(1,new Color(75,54,63));
        tile.setPreferredSize(new Dimension(panelWidth,panelHeight));
        panel.add(tile);
        tile.setVisible(true);
        
        
        
        m = new Music();
        m.startMusic();

        showFrame();
    }

    private void showFrame() {
        frame.setVisible(true);
    }
}
