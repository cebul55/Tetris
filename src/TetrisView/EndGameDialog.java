package TetrisView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class EndGameDialog extends JDialog {
    private static final int HEIGHT = 150;
    private static final int WIDTH = 300;

    private JButton newGameButton = new JButton("New Game");;
    private JButton exitGameButton = new JButton("Exit Game");;
    private JButton settingsButton = new JButton("Settings");
    private JLabel endGameLabel = new JLabel();

    EndGameDialog(JFrame owner , int score)
    {
        super(owner, "Game Over", true);

        JPanel endGamePanel = new JPanel();
        this.setSize(WIDTH, HEIGHT);
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getSize().width/2,
                    dim.height/2 - this.getSize().height/2);

        endGameLabel.setText("Game Over.\nYour score is: "+ score);

        endGamePanel.add(endGameLabel);
        endGamePanel.add(newGameButton);
        endGamePanel.add(settingsButton);
        endGamePanel.add(exitGameButton);

        this.add(endGamePanel, BorderLayout.CENTER);

    }

    EndGameDialog(JFrame owner )
    {
        super(owner, "Game Over", true);

        JPanel endGamePanel = new JPanel();
        this.setSize(WIDTH, HEIGHT);
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getSize().width/2,
                dim.height/2 - this.getSize().height/2);

        endGameLabel.setText("Game Over.\nYour score is: ");

        endGamePanel.add(endGameLabel);
        endGamePanel.add(newGameButton);
        endGamePanel.add(settingsButton);
        endGamePanel.add(exitGameButton);

        this.add(endGamePanel, BorderLayout.CENTER);

    }

    void changeTextLabel(int score)
    {
        endGameLabel.setText("Game Over.\nYour score is: "+ score);
    }

    void addButtonListener(ActionListener l)
    {
        settingsButton.addActionListener(l);
        newGameButton.addActionListener(l);
        exitGameButton.addActionListener(l);
    }
}
