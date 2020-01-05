package Graphics;

import Logic.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window {
    JFrame frame;
    JPanel panel;
    JPanel inner;
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
        panel.setLayout(new GridBagLayout());

        inner = new JPanel();
        inner.setPreferredSize(new Dimension(panelWidth-20,panelHeight-20));
        inner.setBackground(new Color(56,52,55));
        inner.setLayout(new GridLayout(4,4,10,10));
        panel.add(inner);


//        int number = 1;
//        for(int i = 0; i < 4; i++){
        for(int j = 1; j < 16; j++){
            Tile tile = new Tile(j);
            tile.setBackground(new Color(35,54,63).brighter());
            tile.setPreferredSize(new Dimension());
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
//            number++;
        }


        frame.add(panel);
//        frame.setContentPane(panel);

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

