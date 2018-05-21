package TetrisControler;

import TetrisModel.TetrisModel;
import TetrisModel.RandomShapeGenerator;
import TetrisModel.TetrisShape;
import TetrisView.TetrisView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * TetrisControler-klasa sluzaca do komunikacji pomiedzy modelem i widokiem. Rejestruje przekazane przez widok akcje uzytokwnika
 * oraz wysyla do widoku zmiany dokonana przez model.
 */

public class TetrisControler {
    private TetrisModel model;
    private TetrisView view;

    private TetrisShape[] twoShapes;

    public TetrisControler() {
        model = new TetrisModel();

        view = new TetrisView();

        this.view.addTetrisKeyListener(new TetrisKeyListener());
        this.view.addButtonListener(new ButtonListener());
        this.view.addBoardFocusListener(new BoardFocusListener());
        this.view.addComboListener(new ComboListener());

        view.setVisible(true);



        twoShapes = new TetrisShape[2];

        this.modelAddShape();


        model.printBoard();
        displayBoard();
        displayNextShapeBoard();
    }

    void modelAddShape()
    {
        model.addShape(new RandomShapeGenerator().getTetrisShape() );
        twoShapes[0] = model.getCurrentShape();
        twoShapes[1] = model.getNextShape();
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

    private void displayNextShapeBoard()
    {
        int x, y , c = 0;
        for ( int i = 0 ; i < 4 ; i++ )
        {
            for ( int j = 0 ; j < 4 ; j++)
            {
                view.setNextShapeViewWhite(i,j);
            }
        }

        for( int i = 0 ; i < 4; i++)
        {
            x = model.getNextShape().getBlockX(i) - (model.getWIDTH()-4)/2 ;
            y = model.getNextShape().getBlockY(i);
            c = model.getNextShape().getBlockColor(i);

            view.setNextShapeViewColor(x,y,c);
        }

        view.changeDisplayedScore(model.getScore());
        view.changeDisplayedLevel(model.getLevel()  );
    }

    private void endGame()
    {
        view.endGame(model.getScore());
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
                    if(model.moveShapeDown() == 1)
                        endGame();
                    displayBoard();
                    displayNextShapeBoard();
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
                case KeyEvent.VK_SPACE:
                {
                    while (model.moveShapeDown() == 0){
                        displayBoard();
                    }
                    displayBoard();
                    displayNextShapeBoard();
                    break;
                }
                case KeyEvent.VK_C:
                {
                    view.setBoardDefaultColor(Color.BLACK);
                    displayBoard();
                    displayNextShapeBoard();
                    break;
                }
                case KeyEvent.VK_ESCAPE:
                {
                    view.setSettingsWindowVisible();
                    break;
                }
            }
            view.revalidate();

        }

        @Override
        public void keyReleased(KeyEvent e) {}

        @Override
        public void keyTyped(KeyEvent e) {}
    }

    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            JButton button =  (JButton) event.getSource();
            switch (button.getText() )
            {
                case "Settings": {
                    view.hideEndGameDialog();
                    view.setSettingsWindowVisible();
                    break;
                }
                case "New Game": {
                    view.hideEndGameDialog();
                    model = new TetrisModel();
                    modelAddShape();
                    displayBoard();
                    displayNextShapeBoard();
                    break;
                }
                case "Exit Game":
                {
                    System.exit(0);
                    break;
                }
            }
        }
    }

    class BoardFocusListener implements MouseListener
    {
        @Override
        public void mouseEntered(MouseEvent mouseEvent) {}

        @Override
        public void mouseClicked(MouseEvent mouseEvent)
        {
            view.grabBoardFocus();
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {}

        @Override
        public void mouseExited(MouseEvent mouseEvent) {}

        @Override
        public void mousePressed(MouseEvent mouseEvent) {}
    }

    class ComboListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            JComboBox<String> box;
            box = (JComboBox<String>) event.getSource();
            switch (box.getItemAt(box.getSelectedIndex())){
                case "ON":
                {
                    view.setBoardDefaultColor( Color.BLACK );
                    displayBoard();
                    displayNextShapeBoard();
                    view.revalidate();
                    break;
                }
                case "OFF":
                {
                    view.setBoardDefaultColor( Color.WHITE );
                    displayBoard();
                    displayNextShapeBoard();
                    view.revalidate();
                    break;
                }

            }
        }
    }

}
