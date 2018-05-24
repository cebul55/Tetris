package TetrisView;

import javax.swing.*;
import java.awt.*;

public class InfoWindow extends JDialog{
    private static final int HEIGHT = 300;
    private static final int WIDTH = 200;

    private ImageIcon imageIcon = new ImageIcon("/Users/bartoszcybulski/Dropbox/Semestr_4/[PROZ.B]Programowanie Zdarzeniowe/Tetris/src/Images/IMG_0145.jpg");

    InfoWindow(JFrame owner)
    {
        super(owner, "Credits" , true);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        JLabel label = new JLabel(imageIcon);
        label.setPreferredSize(new Dimension(30,30));

        this.add(label, BorderLayout.CENTER);
        //todo credits
        //this.setVisible(true);
    }
}
