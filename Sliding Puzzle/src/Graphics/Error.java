package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Error {
    private JFrame jf;
    private JTextArea txt;

    public Error() {
        jf = new JFrame();
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                txt.setText("");
                jf.setVisible(false);
                jf.dispose();
            }
        });
        jf.setSize(new Dimension(250,250));
        jf.setResizable(false);

        txt = new JTextArea();
        txt.setEditable(false);

        jf.add(txt);
    }
    
    public void editText(String s) {
        txt.setText(s);
    }

    public void showError() {
        jf.setVisible(true);
    }
}
