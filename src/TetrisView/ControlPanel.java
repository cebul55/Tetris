package TetrisView;

import javax.swing.*;

public class ControlPanel extends JPanel{
    TetrisBoardView nextShapeView;
    JLabel scoreField;
    //JButton pauseButton;

    ControlPanel(TetrisBoardView nextView)
    {
        nextShapeView = nextView;
        JLabel scoreField = new JLabel("new");
        scoreField.setText("das");
        //JButton pauseButton = new JButton("PAUSE");


        this.add(scoreField);
        this.add(nextView);
        //this.add(pauseButton);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    void changeScore()
    {
        scoreField.setText("daawea");
    }

    //todo find out why jlabel is null , add listeners and so on
    //todo create time controller
}
