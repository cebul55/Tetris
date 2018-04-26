package TetrisModel;

/**
 * TetrisModel -klasa przechowujaca dane na temat aktualnej zawartosci planszy Tetris
 */

public class TetrisModel {
    private static int WIDTH = 10;
    private static int HEIGHT = 22;

    private int[][] tetrisBoard;
    private int tetrisScore;

    //TODO implement SHAPE
    //TODO przechowywanie aktualnego oraz NASTEPNEGO ksztaltu

    public TetrisModel()
    {
        tetrisBoard = new int[HEIGHT][WIDTH];
        tetrisScore = 0;
    }
}
