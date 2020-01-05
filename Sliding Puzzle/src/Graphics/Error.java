package Graphics;

import javax.swing.*;
import java.awt.*;

public class Error {
    private JFrame jf;
    private JTextArea txt;

    public Error() {
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setSize(new Dimension(250,250));
        jf.setResizable(false);

        txt = new JTextArea();
        txt.setEditable(false);

        jf.add(txt);
    }

    public void editText(String s) {
        txt.append(s);
    }

    public void showError() {
        jf.setVisible(true);
    }
}
