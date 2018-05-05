package TetrisModel;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;

/**
 * TetrisModel -klasa przechowujaca dane na temat aktualnej zawartosci planszy Tetris
 */

public class TetrisModel {
    private static int WIDTH = 10;
    private static int HEIGHT = 20;

    private RandomShapeGenerator shapeGenerator;
    private int tetrisScore;
    private static boolean[][] tetrisBoard;
    private ArrayList<TetrisShape> shapesOnBoard;
    private TetrisShape currentShape;

    //TODO implement SHAPE
    //TODO przechowywanie aktualnego oraz NASTEPNEGO ksztaltu

    public TetrisModel()
    {
        shapeGenerator = new RandomShapeGenerator();
        shapesOnBoard = new ArrayList<>();
        tetrisBoard = new boolean[HEIGHT][WIDTH];
        tetrisScore = 0;

        for( int i = 0 ; i < HEIGHT; i++)
        {
            for(int j = 0 ; j < WIDTH ; j++)
            {
                tetrisBoard[i][j] = false;
            }
        }

        //not elemeent of declaration, just test of different shapes

        TetrisShape shape;
        shape = shapeGenerator.getTetrisShape();
        this.addShape(shape);

        this.moveShapeLeft();


        for( int i = 0 ; i < HEIGHT; i++)
        {
            for(int j = 0 ; j < WIDTH ; j++)
            {
                if(!tetrisBoard[i][j])
                {
                    System.out.print("0 ");
                }
                else
                {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }

    }

    public static int getHEIGHT()
    {
        return HEIGHT;
    }
    public static int getWIDTH()
    {
        return WIDTH;
    }

    public TetrisShape getCurrentShape()
    {
        return this.currentShape;
    }

    public TetrisShape getShapeFromIndex(int i)
    {
        return shapesOnBoard.get(i);
    }

    public int shapesCount()
    {
        return shapesOnBoard.size();
    }

    public void addShape(TetrisShape shape)
    {
        this.currentShape = shape;
        shapesOnBoard.add(shape);

        for(int i = 0 ; i < 4 ; i++)
        {
            tetrisBoard[shape.getBlockY(i)][shape.getBlockX(i)] = true;
        }
    }

    public void moveShapeDown() {
        //Setting current positions on board to false
        for (int i = 0; i < 4; i++) {
            tetrisBoard[this.currentShape.getBlockY(i)][this.currentShape.getBlockX(i)] = false;
        }
        //setting new position for shape
        for (int i = 0; i < 4; i++) {
            this.currentShape.setBlockY(this.currentShape.getBlockY(i) + 1, i);
        }
        //informing board about new position
        for (int i = 0; i < 4; i++) {
            tetrisBoard[currentShape.getBlockY(i)][currentShape.getBlockX(i)] = true;
        }
    }

    public void moveShapeRight()
    {
        //Setting current positions on board to false
        for(int i = 0 ; i < 4 ; i++)
        {
            tetrisBoard[this.currentShape.getBlockY(i)][this.currentShape.getBlockX(i)] = false;
        }
        //setting new position for shape
        for(int i = 0 ; i < 4 ; i++)
        {
            this.currentShape.setBlockX(this.currentShape.getBlockX(i)+1,i);
        }
        //informing board about new position
        for(int i = 0 ; i < 4 ; i++)
        {
            tetrisBoard[currentShape.getBlockY(i)][currentShape.getBlockX(i)] = true;
        }
    }

    public void moveShapeLeft()
    {
        //Setting current positions on board to false
        for(int i = 0 ; i < 4 ; i++)
        {
            tetrisBoard[this.currentShape.getBlockY(i)][this.currentShape.getBlockX(i)] = false;
        }
        //setting new position for shape
        for(int i = 0 ; i < 4 ; i++)
        {
            this.currentShape.setBlockX(this.currentShape.getBlockX(i)-1,i);
        }
        //informing board about new position
        for(int i = 0 ; i < 4 ; i++)
        {
            tetrisBoard[currentShape.getBlockY(i)][currentShape.getBlockX(i)] = true;
        }
    }
}
