package TetrisView;

import javax.swing.*;
import java.awt.event.ActionListener;

class ControlPanel extends JPanel{

    private JPanel controlPanel = new JPanel();
    private TetrisBoardView nextShapeView;
    private JLabel scoreField = new JLabel();
    private JButton settingsButton = new JButton("Settings");
    //JButton pauseButton;

    ControlPanel(TetrisBoardView nextView)
    {
        nextShapeView = nextView;
        scoreField.setText("Score: 0");
        //JButton pauseButton = new JButton("PAUSE");

        controlPanel.add(scoreField);
        controlPanel.add(nextShapeView);
        controlPanel.add(settingsButton);

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

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

    void addSettingsButtonListener(ActionListener l)
    {
        settingsButton.addActionListener(l);
    }
    //todo find out why jlabel is null , add listeners and so on
    //todo create time controller
}
