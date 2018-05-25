package TetrisView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * EndGameDialog pops out after loosing the game
 */

class EndGameDialog extends JDialog {
    private static final int HEIGHT = 150;
    private static final int WIDTH = 300;

    private JButton newGameButton = new JButton("New Game");;
    private JButton exitGameButton = new JButton("Exit Game");;
    private JButton settingsButton = new JButton("Settings");
    private JButton helpButton = new JButton("Help");
    private JLabel endGameLabel = new JLabel();

    EndGameDialog(JFrame owner , int score)
    {
        super(owner, "Game Over", true);

        this.setSize(WIDTH, HEIGHT);
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getSize().width/2,
                    dim.height/2 - this.getSize().height/2);

        JPanel endGamePanel = new JPanel();
        GridLayout gridLayout = new GridLayout(0,1);

        endGamePanel.setLayout(gridLayout);

        endGameLabel.setText("Game Over.\nYour score is: "+ score);

        endGamePanel.add(endGameLabel);
        endGamePanel.add(newGameButton);
        endGamePanel.add(settingsButton);
        endGamePanel.add(helpButton);
        endGamePanel.add(exitGameButton);

        this.add(endGamePanel, BorderLayout.CENTER);

    }

    EndGameDialog(JFrame owner )
    {
        super(owner, "Game Over", true);

        this.setSize(WIDTH, HEIGHT);
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getSize().width/2,
                dim.height/2 - this.getSize().height/2);

        JPanel endGamePanel = new JPanel();
        GridLayout gridLayout = new GridLayout(0,1);

        endGamePanel.setLayout(gridLayout);

        endGameLabel.setText("Game Over.\nYour score is: ");

        endGamePanel.add(endGameLabel);
        endGamePanel.add(newGameButton);
        endGamePanel.add(settingsButton);
        endGamePanel.add(helpButton);
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
        helpButton.addActionListener(l);
    }
}
