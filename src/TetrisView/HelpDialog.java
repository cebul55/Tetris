package TetrisView;

import javax.swing.*;
import java.awt.*;

/**
 * HelpDialog extends JDialog
 * displays info about controls
 */

public class HelpDialog extends JDialog{
    private static final int HEIGHT = 600;
    private static final int WIDTH = 300;

    //private ImageIcon imageIcon = new ImageIcon("/Users/bartoszcybulski/Dropbox/Semestr_4/[PROZ.B]Programowanie Zdarzeniowe/Tetris/src/Images/IMG_0145.jpg");
    private static JLabel upKey = new JLabel();
    private static JLabel downKey = new JLabel();
    private static JLabel leftKey = new JLabel();
    private static JLabel rightKey = new JLabel();
    private static JLabel spaceBar = new JLabel();
    private static JLabel escapeKey = new JLabel();
    private static JLabel hKey = new JLabel();
    private static JLabel nKey = new JLabel();
    private static JLabel helpMessage = new JLabel("Help Menu.\n To close, exit window");

    HelpDialog(JFrame owner)
    {
        super(owner, "Help" , true);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(0 , 1);
        gridLayout.setHgap(10);
        panel.setLayout(gridLayout);

        java.net.URL imageURL;

        imageURL = this.getClass().getClassLoader().getResource("keysIcon/up.png");
        upKey.setIcon(new ImageIcon(imageURL));
        upKey.setText("-> Rotate Tetrominoe");

        imageURL = this.getClass().getClassLoader().getResource("keysIcon/down.png");
        downKey.setIcon(new ImageIcon(imageURL));
        downKey.setText("-> Move Tetrominoe down");

        imageURL = this.getClass().getClassLoader().getResource("keysIcon/left.png");
        leftKey.setIcon(new ImageIcon(imageURL));
        leftKey.setText("-> Move Tetrominoe left");

        imageURL = this.getClass().getClassLoader().getResource("keysIcon/right.png");
        rightKey.setIcon(new ImageIcon(imageURL));
        rightKey.setText("-> Move Tetrominoe right");

        imageURL = this.getClass().getClassLoader().getResource("keysIcon/space.png");
        spaceBar.setIcon(new ImageIcon(imageURL));
        spaceBar.setText("-> Drop Tetrominoe");

        imageURL = this.getClass().getClassLoader().getResource("keysIcon/esc.png");
        escapeKey.setIcon(new ImageIcon(imageURL));
        escapeKey.setText("-> Open Settings");

        imageURL = this.getClass().getClassLoader().getResource("keysIcon/h.png");
        hKey.setIcon(new ImageIcon(imageURL));
        hKey.setText("-> Open Help");

        imageURL = this.getClass().getClassLoader().getResource("keysIcon/n.png");
        nKey.setIcon(new ImageIcon(imageURL));
        nKey.setText("-> New Game");

        panel.add(upKey);
        panel.add(downKey);
        panel.add(leftKey);
        panel.add(rightKey);
        panel.add(spaceBar);
        panel.add(escapeKey);
        panel.add(hKey);
        panel.add(nKey);

        this.add(helpMessage, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        //todo change displaying images
        //todo add comments
    }
}
