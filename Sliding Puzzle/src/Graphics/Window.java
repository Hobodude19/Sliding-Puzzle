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

        frame = new JFrame("Sliding Puzzle");

        frame.getContentPane().setBackground(new Color(75,79,87));
        frame.setSize(1200,900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(panelWidth,panelHeight));
        panel.setBackground(new Color(56,52,55));
        panel.setLayout(new SpringLayout());
        frame.add(panel);
        
        for(int i = 10; i < 700; i = i + 155){
            for(int j = 10; j < 700; j = j + 155){
                Tile tile = new Tile(1,j,i,new Color(35,54,63).brighter());
                tile.setPreferredSize(new Dimension(panelWidth,panelHeight));
//                panel.add(tile.label);
                panel.add(tile);
            }
        }
        

        m = new Music();
        m.startMusic();

        showFrame();
    }

    private void showFrame() {
        frame.setVisible(true);
    }
}
