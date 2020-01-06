package Graphics;

import Logic.Music;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.*;

public class Window {
    JFrame frame;
    JPanel panel;
    JPanel inner;
    int panelWidth = 800;
    int panelHeight = 800;
    Music m;
    Color frameC;
    Color panelC;
    Color tileC;

    public Window() {
        frameC = new Color(75,79,87);
        panelC = new Color(56,52,55);
        tileC = new Color(35,54,63).brighter();
        
        //The main window
        frame = new JFrame("Sliding Puzzle");
        frame.getContentPane().setBackground(frameC);
        frame.setSize(1200,900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());//Fits all the components on the frame to the center

        //The panel for the game
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(panelWidth,panelHeight));
        panel.setBackground(new Color(56,52,55));
        panel.setLayout(new GridBagLayout());//Centered layout

        //GridLayout puts spaces in between its components but does not put the space in between the edges
        inner = new JPanel();
        inner.setPreferredSize(new Dimension(panelWidth-20,panelHeight-20));
        inner.setBackground(new Color(56,52,55));
        inner.setLayout(new GridLayout(4,4,10,10));//
        panel.add(inner);

        //The panel for the game
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(panelWidth,panelHeight));
        panel.setBackground(panelC);
        panel.setLayout(new GridBagLayout());//Centered layout
        
        //GridLayout puts spaces in between its components but does not put the space in between the edges
        inner = new JPanel();
        inner.setPreferredSize(new Dimension(panelWidth-20,panelHeight-20));
        inner.setBackground(panelC);
        inner.setLayout(new GridLayout(4,4,10,10));//Spaces the components 10 pixels apart vertically and horizontally
        panel.add(inner);
        
        ArrayList<Tile> tiles = new ArrayList<Tile>();
        for(int i = 1; i < 16; i++){
            Tile tile = new Tile(i);
            tile.setBackground(tileC);
            tile.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {

                }
                public void mousePressed(MouseEvent e) {
                    System.out.println(tile.number+" was clicked!");
                }
                @Override
                public void mouseReleased(MouseEvent e) {

                }
                @Override
                public void mouseEntered(MouseEvent e) {

                }
                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            tiles.add(tile);
        }
        Tile blank = new Tile(16);
        blank.setBackground(panelC);
        blank.label.setForeground(panelC);
        tiles.add(blank);
      
        Collections.shuffle(tiles);
        for(int i = 0; i < 16; i++) {
            inner.add(tiles.get(i));
            System.out.println(tiles.get(i).number);
        }

        frame.add(panel);

        m = new Music();
        m.startMusic();

        //Creates button for starting music and adds action listener
        JButton startMusic = new JButton("Play Music");
        startMusic.addActionListener(e -> m.startMusic());
        startMusic.setPreferredSize(new Dimension(100,30));

        //Creates button for starting music and adds action listener
        JButton stopMusic = new JButton("Stop Music");
        stopMusic.addActionListener(e -> m.stopMusic());
        stopMusic.setPreferredSize(new Dimension(100,30));

        frame.add(startMusic);
        frame.add(stopMusic);

        showFrame();
    }

    private void showFrame() {
        frame.setVisible(true);
    }
}

