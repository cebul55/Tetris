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

    public TetrisView()
    {
        setTitle("TETRIS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(HEIGHT, WIDTH);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getSize().width/2 , dim.height/2 - this.getSize().height/2);

        boardView = new TetrisBoardView();
        add(boardView, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void setBoardColor(int x, int y, int c)
    {
        boardView.setColorOfBoard(x,y,c);
    }

    public void setBoardWhite(int y, int x)
    {
        boardView.setWhiteColorOfBoard(y,x);
    }
}

