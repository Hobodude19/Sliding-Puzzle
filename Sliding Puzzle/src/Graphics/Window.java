package Graphics;

import Logic.Music;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.*;

public class Window {
    public JFrame frame;
    JPanel panel;
    JPanel inner;
    JLabel winLabel;
    int panelWidth = 800;
    int panelHeight = 800;
    int index = 0;
    int left = -1;
    int right = -1;
    int up = -1;
    int down = -1;
    Music m;
    Color frameC;
    Color panelC;
    Color tileC;
    Color winC;
    private int lastClicked = -1;
    ArrayList<Integer> validMoves = new ArrayList<>(); //Stores indices of valid move. Indices relate to tiles arraylist
    ArrayList<Tile> tiles = new ArrayList<Tile>(); //Stores all tiles

    public Window() {
        frameC = new Color(75,79,87);
        panelC = new Color(56,52,55);
        tileC = new Color(35,54,63).brighter();
        winC = Color.decode("0xD4AF37");

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
        panel.setBackground(panelC);
        panel.setLayout(new GridBagLayout());//Centered layout

        //GridLayout puts spaces in between its components but does not put the space in between the edges
        inner = new JPanel();
        inner.setPreferredSize(new Dimension(panelWidth-20,panelHeight-20));
        inner.setBackground(panelC);
        inner.setLayout(new GridLayout(4,4,10,10));//Spaces the components 10 pixels apart vertically and horizontally
        panel.add(inner);

        winLabel = new JLabel("You win!");
        winLabel.setFont(winLabel.getFont().deriveFont(100f));
        winLabel.setVisible(false);
        panel.add(winLabel);

        for(int i = 1; i < 16; i++){
            Tile tile = new Tile(i);
            tile.setBackground(tileC);
            tile.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {

                }
                public void mousePressed(MouseEvent e) {
                    if(lastClicked != -1) {
                        for(int j = 0; j < 16; j++) {
                            if(tiles.get(j).number == lastClicked && tiles.get(j).number != tile.number && tiles.get(j).isBorder()) {
                                tiles.get(j).toggleBorder();
                            }
                        }
                    }

                    lastClicked = tile.number;
                    tile.toggleBorder();
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
        blank.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                updateAvailTiles();
                for(int i = 0; i < validMoves.size(); i++) {
                    if(tiles.get(validMoves.get(i)).isBorder()) { //Checks if border is active on any of the valid moves
                        Collections.swap(tiles, validMoves.get(i), index);
                        tiles.get(index).toggleBorder();
                        updateTiles();
                        if(checkWin()) {
                            endGame();
                        }
                        frame.validate();
                        frame.repaint();
                    }
                }
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
        tiles.add(blank);

        //randomizeTiles();

        for(int i = 0; i < 16; i++) {
            inner.add(tiles.get(i));
        }

        frame.add(panel);

        m = new Music();

        //Creates button for starting music and adds action listener
        JButton startMusic = new JButton("Play Music");
        startMusic.addActionListener(e -> m.startMusic());
        startMusic.setPreferredSize(new Dimension(100,30));

        //Creates button for starting music and adds action listener
        JButton stopMusic = new JButton("Pause Music");
        stopMusic.addActionListener(e -> m.stopMusic());
        stopMusic.setPreferredSize(new Dimension(125,30));

        frame.add(startMusic);
        frame.add(stopMusic);

        showFrame();
    }

    private void showFrame() {
        frame.setVisible(true);
    }

    public void updateTiles() {
        for(int i = 0; i < 16; i++) {
            inner.remove(tiles.get(i));
        }

        for(int i = 0; i < 16; i++) {
            inner.add(tiles.get(i));
//            frame.validate();
//            frame.repaint();
        }
    }

    public void updateAvailTiles() {
        left = -1;
        right = -1;
        up = -1;
        down = -1;
        validMoves.clear();
        for(int i = 0; i < 16; i++){//Should find the index of the blank no matter what
            if(tiles.get(i).number == 16){
                index = i;
                break;
            }
        }
        try{
            tiles.get(index-1);
            if(index % 4 != 0)
                left = index-1;
        }
        catch(IndexOutOfBoundsException e){
        }
        try{
            tiles.get(index+1);
            if((index+1)%4 != 0)//3,7,11,15
                right = index+1;
        }
        catch(IndexOutOfBoundsException e){
        }
        try{
            tiles.get(index-4);
            up = index-4;
        }
        catch(IndexOutOfBoundsException e){
        }
        try{
            tiles.get(index+4);
            down = index+4;
        }
        catch(IndexOutOfBoundsException e){
        }
        if(left != -1)
            validMoves.add(left);
        if(right != -1)
            validMoves.add(right);
        if(up != -1)
            validMoves.add(up);
        if(down != -1)
            validMoves.add(down);
    }

    public void randomizeTiles() {
        for(int i = 0; i < 100; i++) {
            updateAvailTiles();
            int random = (int) (Math.random() * validMoves.size());
            Collections.swap(tiles, validMoves.get(random), index);
//            updateTiles();
//            frame.validate();
//            frame.repaint();
//            System.out.println(validMoves);
        }
    }

    public boolean checkWin() {
        int temp = 0;
        for(int i = 0; i < tiles.size(); i++) {
            if(tiles.get(i).number == (i + 1)) {
                temp++;
            }
        }
        if(temp == 16) {
            return true;
        }
        else {
            return false;
        }
    }

    public void endGame() {
        inner.setVisible(false);
        winLabel.setVisible(true);
        panel.setBorder(BorderFactory.createLineBorder(winC, 4));
        frame.validate();
        frame.repaint();
    }
}