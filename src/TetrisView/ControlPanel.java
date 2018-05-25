package TetrisView;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * ControlPanel is panel displayed in view next to TetrisBoard
 * it shows info about score, level , next shape comming to the board
 * contains buttons NewGame, Settings, Help
 */

class ControlPanel extends JPanel{

    private JPanel controlPanel = new JPanel();
    private TetrisBoardView nextShapeView;
    private JLabel levelField = new JLabel();
    private JLabel scoreField = new JLabel();
    private JButton settingsButton = new JButton("Settings");
    private JButton newGameButton = new JButton("New Game");
    private JButton helpButton = new JButton("Help");
    //JButton pauseButton;

    ControlPanel(TetrisBoardView nextView)
    {
        nextShapeView = nextView;
        levelField.setText("Level: 1");
        scoreField.setText("Score: 0");
        //JButton pauseButton = new JButton("PAUSE");

        controlPanel.add(levelField);
        controlPanel.add(scoreField);
        controlPanel.add(nextShapeView);
        controlPanel.add(settingsButton);
        controlPanel.add(newGameButton);
        controlPanel.add(helpButton);

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        this.add(Box.createHorizontalStrut(10));
        this.add(Box.createHorizontalStrut(10));
        this.add(controlPanel);

        //this.add(scoreField);
        //this.add(nextView);
        //this.add(pauseButton);


    }

    void changeScore(int score)
    {
        scoreField.setText("Score: " + score);
        controlPanel.revalidate();
    }

    void changeLevel(int level)
    {
        levelField.setText("Level: " + level);
        controlPanel.revalidate();
    }

    void addButtonListener(ActionListener l)
    {
        settingsButton.addActionListener(l);
        newGameButton.addActionListener(l);
        helpButton.addActionListener(l);
    }

}
