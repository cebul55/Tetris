package TetrisView;

import javax.swing.*;
import java.awt.*;

/**
 * TetrisView - klasa sluzaca do komunikacji z uzytkownikiem. Wyswietla aktualna zawartosc planszy oraz przekazuje wykonane przez
 * uzytkownika akcje do kontrolera.
 * Posiada takie informacje jak liczba punktow, czy aktualny poziom uzytkownika
 */

public class TetrisView extends JFrame{
    public static final int HEIGHT = 800;
    public static final int WIDTH = 600;

    private TetrisBoardView boardView;
    private TetrisBoardView nextShapeView;
    private ControlPanel controlPanel;
    private EndGameDialog endGameDialog;
    private SettingsWindow settingsWindow;

    public TetrisView()
    {
        setTitle("TETRIS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getSize().width/2 , dim.height/2 - this.getSize().height/2);

        boardView = new TetrisBoardView();
        add(boardView, BorderLayout.CENTER);

        nextShapeView = new TetrisBoardView(4,4);
        //add(nextShapeView, BorderLayout.EAST);
        controlPanel = new ControlPanel(nextShapeView);
        add(controlPanel, BorderLayout.EAST);

        settingsWindow = new SettingsWindow(this);


        this.setVisible(true);
    }

    public void setBoardColor(int x, int y, int c)
    {
        boardView.setColorOfBoard(x,y,c);
    }

    public void setBoardWhite(int y, int x)
    {
        boardView.setDefaultColorOfBoard(y,x);
    }
    public void setNextShapeViewColor(int x, int y , int c)
    {
        nextShapeView.setColorOfBoard(x,y,c);
    }
    public void setNextShapeViewWhite(int y, int x)
    {
        nextShapeView.setDefaultColorOfBoard(y,x);
    }

    public void endGame(int score)
    {
        endGameDialog = new EndGameDialog(this,10);
        endGameDialog.setVisible(true);
    }
    public void setBoardDefaultColor(Color c)
    {
        boardView.setDefaultColor(c);
    }
    public void setSettingsWindowVisible()
    {
        settingsWindow.setVisible(true);
    }
}

