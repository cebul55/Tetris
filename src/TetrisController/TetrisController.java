package TetrisController;

import TetrisModel.TetrisModel;
import TetrisModel.RandomShapeGenerator;
import TetrisModel.TetrisShape;
import TetrisView.TetrisView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * TetrisController-klasa sluzaca do komunikacji pomiedzy modelem i widokiem. Rejestruje przekazane przez widok akcje uzytokwnika
 * oraz wysyla do widoku zmiany dokonana przez model.
 */

public class TetrisController {
    private TetrisModel model;
    private TetrisView view;

    private TetrisShape[] twoShapes;

    public TetrisController()
    {
        model = new TetrisModel();
        view = new TetrisView();
        this.view.addKeyListener(new TetrisKeyListener());
        view.setVisible(true);

        twoShapes = new TetrisShape[2];

        model.addShape(new RandomShapeGenerator().getTetrisShape() );
        twoShapes[0] = model.getCurrentShape();
        twoShapes[1] = model.getNextShape();


        model.printBoard();
        displayBoard();
    }

    private void displayBoard()
    {
        //color the board
        int x , y , c = 0;
        for(int i = 0 ; i < model.getNumberOfShapes(); i++)
        {
            for(int j = 0 ; j< model.getShapeFromIndex(i).getNumberOfBlocks(); j++)
            {
                x = model.getShapeFromIndex(i).getBlockX(j);
                y = model.getShapeFromIndex(i).getBlockY(j);
                c = model.getShapeFromIndex(i).getBlockColor(j);

                view.setBoardColor(x,y,c);
            }
        }

        for(int i = 0 ; i < model.getHEIGHT(); i++)
        {
            for(int j = 0 ; j < model.getWIDTH(); j++)
            {
                //if block is false set color to white
                if(!model.getStateOfCell(i,j))
                    view.setBoardWhite(i,j);
            }
        }
    }

    class TetrisKeyListener implements KeyListener {

        private int keyCode;
        @Override
        public void keyPressed(KeyEvent e)
        {
            keyCode = e.getKeyCode();
            switch(keyCode)
            {
                case KeyEvent.VK_DOWN:
                {
                    model.moveShapeDown();
                    displayBoard();
                    break;
                }
                case KeyEvent.VK_UP:
                {
                    model.rotateShapeRight();
                    displayBoard();
                    break;
                }
                case KeyEvent.VK_RIGHT:
                {
                    model.moveShapeRight();
                    displayBoard();
                    break;
                }
                case KeyEvent.VK_LEFT:
                {
                    model.moveShapeLeft();
                    displayBoard();
                    break;
                }
            }

            model.printSumInLines();
        }

        @Override
        public void keyReleased(KeyEvent e) {}

        @Override
        public void keyTyped(KeyEvent e) {}
    }
}
