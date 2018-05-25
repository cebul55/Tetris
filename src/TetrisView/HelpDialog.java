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
    private JLabel upKey = new JLabel();
    private JLabel downKey = new JLabel();
    private JLabel leftKey = new JLabel();
    private JLabel rightKey = new JLabel();
    private JLabel spaceBar = new JLabel();
    private JLabel escapeKey = new JLabel();
    private JLabel hKey = new JLabel();
    private JLabel nKey = new JLabel();
    private JLabel helpMessage = new JLabel("Help Menu.\n To close, exit window");


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
        upKey.setIcon(new ImageIcon("/Users/bartoszcybulski/Dropbox/Semestr_4/[PROZ.B]Programowanie Zdarzeniowe/Tetris/src/TetrisView/keysIcon/up.png"));
        upKey.setText("-> Rotate Tetrominoe");

        downKey.setIcon(new ImageIcon("/Users/bartoszcybulski/Dropbox/Semestr_4/[PROZ.B]Programowanie Zdarzeniowe/Tetris/src/TetrisView/keysIcon/down.png"));
        downKey.setText("-> Move Tetrominoe down");

        leftKey.setIcon(new ImageIcon("/Users/bartoszcybulski/Dropbox/Semestr_4/[PROZ.B]Programowanie Zdarzeniowe/Tetris/src/TetrisView/keysIcon/left.png"));
        leftKey.setText("-> Move Tetrominoe left");

        rightKey.setIcon(new ImageIcon("/Users/bartoszcybulski/Dropbox/Semestr_4/[PROZ.B]Programowanie Zdarzeniowe/Tetris/src/TetrisView/keysIcon/right.png"));
        rightKey.setText("-> Move Tetrominoe right");

        spaceBar.setIcon(new ImageIcon("/Users/bartoszcybulski/Dropbox/Semestr_4/[PROZ.B]Programowanie Zdarzeniowe/Tetris/src/TetrisView/keysIcon/space.png"));
        spaceBar.setText("-> Drop Tetrominoe");

        escapeKey.setIcon(new ImageIcon("/Users/bartoszcybulski/Dropbox/Semestr_4/[PROZ.B]Programowanie Zdarzeniowe/Tetris/src/TetrisView/keysIcon/esc.png"));
        escapeKey.setText("-> Open Settings");

        hKey.setIcon(new ImageIcon("/Users/bartoszcybulski/Dropbox/Semestr_4/[PROZ.B]Programowanie Zdarzeniowe/Tetris/src/TetrisView/keysIcon/h.png"));
        hKey.setText("-> Open Help");

        nKey.setIcon(new ImageIcon("/Users/bartoszcybulski/Dropbox/Semestr_4/[PROZ.B]Programowanie Zdarzeniowe/Tetris/src/TetrisView/keysIcon/n.png"));
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
