package TetrisView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

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


        nextShapeView = new TetrisBoardView(4,4);
        controlPanel = new ControlPanel(nextShapeView);

        add(boardView, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);

        settingsWindow = new SettingsWindow(this);
        endGameDialog = new EndGameDialog(this);


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
        //endGameDialog = new EndGameDialog(this,score);
        //endGameDialog.setVisible(true);
        endGameDialog.changeTextLabel(score);
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
    public void changeDisplayedScore(int score)
    {
        controlPanel.changeScore(score);
    }

    public void changeDisplayedLevel(int level)
    {
        controlPanel.changeLevel(level);
    }
    public void addTetrisKeyListener(KeyListener l)
    {
        boardView.addKeyListener(l);
        this.grabBoardFocus();
    }
    public void addButtonListener(ActionListener l)
    {
        controlPanel.addButtonListener(l);
        endGameDialog.addButtonListener(l);
    }

    public void addBoardFocusListener(MouseListener l)
    {
        boardView.addMouseListener(l);
    }

    public void addComboListener(ActionListener l)
    {
        settingsWindow.addComboListener(l);
    }

    public void grabBoardFocus()
    {
        boardView.grabFocus();
        //todo try to implement autofocusing after exiting from another window
    }

    public void hideEndGameDialog()
    {
        endGameDialog.setVisible(false);
    }
}

