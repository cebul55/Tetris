package TetrisView;

import TetrisModel.TetrisModel;

import javax.swing.*;
import java.awt.*;

/**
 * TetrisBoardView element of GUI, showing actual state of tetris board
 */

public class TetrisBoardView extends JPanel {
    private JPanel[][] tetrisBoard;

    private static Color[] colorOfShape;


    private static int height;
    private static int width;

    TetrisBoardView()
    {
        height = TetrisModel.getHEIGHT();
        width = TetrisModel.getWIDTH();

        GridLayout gridLayout = new GridLayout(TetrisModel.getHEIGHT(), TetrisModel.getWIDTH());
        setLayout(gridLayout);

        tetrisBoard = new JPanel[TetrisModel.getHEIGHT()][TetrisModel.getWIDTH()];

        initBoard();
        addBoard();

        colorOfShape = new Color[7];
        colorOfShape[0] = Color.BLUE;
        colorOfShape[1] = Color.GREEN;
        colorOfShape[2] = Color.RED;
        colorOfShape[3] = Color.YELLOW;
        colorOfShape[4] = Color.ORANGE;
        colorOfShape[5] = Color.MAGENTA;
        colorOfShape[6] = Color.CYAN;
    }

    TetrisBoardView(int x, int y)
    {
        height = x;
        width = y;
        GridLayout gridLayout = new GridLayout(x, y);
        setLayout(gridLayout);


        tetrisBoard = new JPanel[x][y];

        initBoard();
        addBoard();

        colorOfShape = new Color[7];
        colorOfShape[0] = Color.BLUE;
        colorOfShape[1] = Color.GREEN;
        colorOfShape[2] = Color.RED;
        colorOfShape[3] = Color.YELLOW;
        colorOfShape[4] = Color.ORANGE;
        colorOfShape[5] = Color.MAGENTA;
        colorOfShape[6] = Color.CYAN;
    }


    private void initBoard()
    {
        //initialize every single Jpanel in Jpanel[][], set dimension
        for( int  i = 0 ; i < height; i++)
        {
            for( int j = 0 ;j < width; j++)
            {
                tetrisBoard[i][j] = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(40, 40);
                    }
                };
                setWhiteColorOfBoard(i, j);
                tetrisBoard[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }
        }
    }

    private void addBoard()
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                add(tetrisBoard[i][j]);
            }
        }
    }

    void setColorOfBoard(int x, int y, int c)
    {
        tetrisBoard[y][x].setBackground(colorOfShape[c]);
    }

    void setWhiteColorOfBoard(int y, int x)
    {
        tetrisBoard[y][x].setBackground(Color.WHITE);
    }
    //todo finist tetris board, wpierdol w view
}


