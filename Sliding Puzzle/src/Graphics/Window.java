package Graphics;

import Logic.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window {
    JFrame frame;
    JPanel panel;
    JPanel inner;
    int panelWidth = 800;
    int panelHeight = 800;
    Music m;

    public Window() {
        //The main window
        frame = new JFrame("Sliding Puzzle");
        frame.getContentPane().setBackground(new Color(75,79,87));
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
        inner.setLayout(new GridLayout(4,4,10,10));//Spaces the components 10 pixels apart vertically and horizontally
        panel.add(inner);
        
        for(int i = 1; i < 16; i++){
            Tile tile = new Tile(i);
            tile.setBackground(new Color(35,54,63).brighter());
//            tile.setPreferredSize(new Dimension());//Dimension doesn't matter since the inner JPanel layout sizes it
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
            inner.add(tile);
        }
        
            
        frame.add(panel);

        m = new Music();
        m.startMusic();
      
        JButton startMusic = new JButton("Play Music");
        startMusic.addActionListener(e -> m.startMusic());
        startMusic.setPreferredSize(new Dimension(100,30));

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

