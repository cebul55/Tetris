package TetrisModel;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;

/**
 * TetrisModel -klasa przechowujaca dane na temat aktualnej zawartosci planszy Tetris
 */

public class TetrisModel {
    private static int WIDTH = 10;
    private static int HEIGHT = 20;
    private static final int NO_DIRECTION = 0;
    private static final int DOWN_DIRECTION = 1;
    private static final int LEFT_DIRECTION = 2;
    private static final int RIGHT_DIRECTION = 3;
    private static final int ROTATE_DIRECTION = 4;

    private RandomShapeGenerator shapeGenerator;
    private LineCleaner lineCleaner;
    private int tetrisScore;
    private static boolean[][] tetrisBoard;
    private ArrayList<TetrisShape> shapesOnBoard;
    private TetrisShape currentShape;
    private TetrisShape nextShape;


    public TetrisModel()
    {
        lineCleaner = new LineCleaner(HEIGHT, WIDTH,this);
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
        //shape = shapeGenerator.getTetrisShape();
        shape = new TetrisShape_J();
        this.addShape(shape);


        settleShape();
        printBoard();

    }

    void addToScore(int score)
    {
        tetrisScore += score;
    }

    public boolean[][] getTetrisBoard()
    {
        return tetrisBoard;
    }


    private void setNextShape(TetrisShape shape)
    {
        nextShape = shape;
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
        //jako jedyna ta funkcja przyrownuje nextShape do tablicy

        this.currentShape = shape;
        shapesOnBoard.add(shape);
        setNextShape(shapeGenerator.getTetrisShape());

        if( !checkIfCanMove(NO_DIRECTION) )
        {
            System.out.println("Error cannot add. Game is over");
            return;
        }

        this.setVisible();
    }

    public void moveShapeDown() {
        //checking if shape can move down
        this.setInvisible();
        if(!checkIfCanMove(DOWN_DIRECTION))
        {
            System.out.println("Nie możesz wyjść w dół po za krawędź, Dodaję nowy element");

            //wywolanie funkcji settleshape ustawia ksztalt na tablicy na stale
            this.settleShape();
            //dodanie kolejnego ksztaltu
            this.addShape(nextShape);
            return;
        }


        //setting new position for shape
        for (int i = 0; i < 4; i++) {
            this.currentShape.setBlockY(this.currentShape.getBlockY(i) + 1, i);
        }
        //informing board about new position
        this.setVisible();
    }

    public void moveShapeRight()
    {
        //checking if shape can move right
        this.setInvisible();
        if(!checkIfCanMove(RIGHT_DIRECTION))
        {
            System.out.println("Nie możesz wyjść w prawo po za krawędź");
            return;
        }


        //setting new position for shape
        for(int i = 0 ; i < 4 ; i++)
        {
            this.currentShape.setBlockX(this.currentShape.getBlockX(i)+1,i);
        }
        //informing board about new position
        this.setVisible();

    }

    public void moveShapeLeft()
    {
        //checking if shape can move left
        this.setInvisible();
        if(!checkIfCanMove(LEFT_DIRECTION))
        {
            System.out.println("Nie możesz wyjść w lewo po za krawędź");
            return;
        }

        //Setting current positions on board to false
        //this.setInvisible();

        //setting new position for shape
        for(int i = 0 ; i < 4 ; i++)
        {
            this.currentShape.setBlockX(this.currentShape.getBlockX(i)-1,i);
        }
        //informing board about new position
        this.setVisible();

    }
    private void setVisible()
    {
        for(int i = 0 ; i < 4 ; i++)
        {
            tetrisBoard[this.currentShape.getBlockY(i)][this.currentShape.getBlockX(i)] = true;
        }
    }

    private void setInvisible()
    {
        for(int i = 0 ; i < 4 ; i++)
        {
            tetrisBoard[this.currentShape.getBlockY(i)][this.currentShape.getBlockX(i)] = false;
        }
    }

    void rotateShapeRight()
    {
        this.setInvisible();
        currentShape.rotateRight();

        if( !checkIfCanMove(ROTATE_DIRECTION) )
        {
            System.out.println("Error cannot rotate");

            currentShape.rotateLeft();
            //cofanie obrotu w razie niepowodzenia
            this.setVisible();
            return;
        }

        //informing board about new position
        this.setVisible();
    }

    void rotateShapeLeft()
    {
        this.setInvisible();
        currentShape.rotateLeft();

        if( !checkIfCanMove(ROTATE_DIRECTION) )
        {
            System.out.println("Error cannot rotate");

            //cofanie obrotu w razie niepowodzenia
            currentShape.rotateRight();
            this.setVisible();

            return;
        }
        //informing board about new position
        this.setVisible();
    }

    /**
     * Funckja checkIfCanMove sprawdza czy można wykonać dane przesunięcie klocka
     * zwraca true jeżeli nic nie stoi na przeszkodzie, ani nie wychodzi po za granice
     * false jeżeli nie można wykonać ruchu
     * Dostępne kierunki :
     * 0 - brak ruchu //oraz sprawdzanie czy mozna obrocic
     * 1 - ruch w dół
     * 2 - ruch w lewo
     * 3 - ruch w prawo
     */

    private boolean checkIfCanMove(int direction)
    {
        boolean doMove = true;

        //gaszenie aktualnego kształtu żeby można było sprawdzic czy nie nakłada się z innymi elementami lub krawedziami
        //this.setInvisible();

        switch (direction)
        {
            case NO_DIRECTION:
                if( nextShape.isEqual(null)){
                    return true;
                }
                else
                {
                    for(int i = 0 ; i < 4 ; i++)
                    {
                        if(tetrisBoard[this.nextShape.getBlockY(i)][this.nextShape.getBlockX(i)])
                            doMove = false;
                    }
                }
                break;
            case DOWN_DIRECTION:
                for(int i = 0 ; i < 4 ; i++)
                {
                    if(this.currentShape.getBlockY(i)+1 == HEIGHT
                            || tetrisBoard[this.currentShape.getBlockY(i) + 1][this.currentShape.getBlockX(i)])
                        doMove = false;

                }
                break;
            case LEFT_DIRECTION:
                for(int i = 0; i < 4 ; i++)
                {
                    if(this.currentShape.getBlockX(i) - 1 < 0
                            || tetrisBoard[this.currentShape.getBlockY(i)][this.currentShape.getBlockX(i) - 1])
                        doMove = false;
                }
                break;
            case RIGHT_DIRECTION:
                for( int i = 0 ; i < 4 ; i++)
                {
                    if(this.currentShape.getBlockX(i) + 1 == WIDTH
                            || tetrisBoard[this.currentShape.getBlockY(i)][this.currentShape.getBlockX(i) + 1])
                        doMove = false;
                }
                break;
            case ROTATE_DIRECTION:
                //sprawdzenie czy nie wyjdzie po za tablice oraz czy nie najedzie na jakis ksztalt
                for( int i = 0 ; i < 4 ; i++)
                {
                    if(this.currentShape.getBlockY(i) >= HEIGHT || this.currentShape.getBlockX(i) >= WIDTH
                            || this.currentShape.getBlockY(i) < 0 || this.currentShape.getBlockX(i) < 0) {
                        doMove = false;
                        return doMove;
                    }
                }
                for(int i = 0 ; i < 4 ; i++)
                {
                    if(tetrisBoard[this.nextShape.getBlockY(i)][this.nextShape.getBlockX(i)])
                        doMove = false;
                }
        }

        //this.setVisible();

        return doMove;
    }

    private void settleShape()
    {
        lineCleaner.shapeIsSettled( this.currentShape.getBlockY(0),
                                    this.currentShape.getBlockY(1),
                                    this.currentShape.getBlockY(2),
                                    this.currentShape.getBlockY(3));

    }

    private void printBoard()
    {
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
}
