package TetrisModel;

import java.lang.reflect.WildcardType;

/**
 * TetrisModel -klasa przechowujaca dane na temat aktualnej zawartosci planszy Tetris
 */

public class TetrisModel {
    private static int WIDTH = 10;
    private static int HEIGHT = 20;

    private int[][] tetrisBoard;
    private int tetrisScore;

    //TODO implement SHAPE
    //TODO przechowywanie aktualnego oraz NASTEPNEGO ksztaltu

    public TetrisModel()
    {
        tetrisBoard = new int[HEIGHT][WIDTH];
        tetrisScore = 0;
    }

    public static int getHEIGHT()
    {
        return HEIGHT;
    }
    public static int getWIDTH()
    {
        return WIDTH;
    }
}
