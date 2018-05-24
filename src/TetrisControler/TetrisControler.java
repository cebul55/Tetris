package TetrisControler;

import TetrisModel.TetrisModel;
import TetrisModel.RandomShapeGenerator;
import TetrisModel.TetrisShape;
import TetrisView.TetrisView;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;
import javax.swing.*;

/**
 * TetrisControler-klasa sluzaca do komunikacji pomiedzy modelem i widokiem. Rejestruje przekazane przez widok akcje uzytokwnika
 * oraz wysyla do widoku zmiany dokonana przez model.
 */

public class TetrisControler {
    private TetrisModel model;
    private TetrisView view;

    private TetrisShape[] twoShapes;

    private Thread timeThread;

    private ScheduledFuture<?> scheduledFuture;
    private ScheduledExecutorService executorService;
    private Runnable moveDownRunnable;

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

        //experiment adding executorService
        moveDownRunnable = new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(model.getSpeed());
                        if (!Thread.interrupted()) {
                            if (model.moveShapeDown() == 1) {
                                displayBoard();
                                displayNextShapeBoard();
                                view.validate();
                                view.repaint();
                                endGame();
                                return;
                            }
                        }
                    }
                    catch(InterruptedException e )
                        {
                            //e.printStackTrace();
                            System.out.println(e.getLocalizedMessage());
                        }
                        displayBoard();
                        displayNextShapeBoard();
                        view.validate();
                        view.repaint();
                    }
            }
        };

        //executorService = Executors.newScheduledThreadPool(1);
        executorService = Executors.newSingleThreadScheduledExecutor();
        changeTimeInterval();

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
                //todo disable coloring empty blocks bug
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

    private void pauseGame(){
        //invalid implementation
        scheduledFuture.cancel(true);
        executorService.shutdown();
    }

    private void resumeGame(){
        scheduledFuture = executorService.schedule(moveDownRunnable, model.getSpeed(), TimeUnit.MILLISECONDS);
    }

    private void endGame()
    {
        scheduledFuture.cancel(true);
        view.endGame(model.getScore());
    }

    private void changeTimeInterval()
    {
        if(scheduledFuture != null)
        {
            scheduledFuture.cancel(true);
        }
        scheduledFuture = executorService.schedule(moveDownRunnable, model.getSpeed(), TimeUnit.MILLISECONDS);
        //scheduledFuture = executorService.scheduleAtFixedRate(moveDownRunnable, 3, model.getSpeed(), TimeUnit.MILLISECONDS);

    }

    private void newThread()
    {
        timeThread = new Thread(){
            @Override
            public void run(){
                while(true)
                {
                    try {
                        Thread.sleep(model.getSpeed());
                        if(!Thread.currentThread().isInterrupted()){
                            if(model.moveShapeDown() == 1)
                            {
                                displayBoard();
                                displayNextShapeBoard();
                                view.revalidate();
                                view.repaint();
                                endGame();
                                return;
                            }
                        }
                    } catch ( InterruptedException e ) {}
                    displayBoard();
                    displayNextShapeBoard();
                    view.revalidate();
                    view.repaint();
                }
            }

        };
        timeThread.setPriority(Thread.NORM_PRIORITY);
        timeThread.start();
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
                    break;
                }
                case KeyEvent.VK_UP:
                {
                    model.rotateShapeRight();
                    break;
                }
                case KeyEvent.VK_RIGHT:
                {
                    model.moveShapeRight();
                    break;
                }
                case KeyEvent.VK_LEFT:
                {
                    model.moveShapeLeft();
                    break;
                }
                case KeyEvent.VK_SPACE:
                {
                    int tmpValue;
                    do{
                        tmpValue = model.moveShapeDown();
                        if(tmpValue == 1) {
                            displayBoard();
                            displayNextShapeBoard();
                            view.revalidate();
                            view.repaint();
                            endGame();
                            return;
                        }
                    }while (tmpValue == 0);

                    break;
                }
                case KeyEvent.VK_ESCAPE:
                {
                    view.setSettingsWindowVisible(true);
                    break;
                }
            }
            displayBoard();
            displayNextShapeBoard();
            view.revalidate();
            view.repaint();

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
                    //todo stop executing thread
//                    try {
//                        timeThread.join(1000);
//                    }
//                    catch (Exception e){}

                    view.hideEndGameDialog();
                    view.setSettingsWindowVisible(true);
                    break;
                }
                case "New Game": {
                    view.hideEndGameDialog();
                    model = new TetrisModel();
                    modelAddShape();
                    view.grabBoardFocus();
                    changeTimeInterval();
                    break;
                }
                case "Exit Game":
                {
                    System.exit(0);
                    break;
                }
            }
            displayBoard();
            displayNextShapeBoard();
            view.revalidate();
            view.repaint();

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
                    break;
                }
                case "OFF":
                {
                    view.setBoardDefaultColor( Color.WHITE );
                    break;
                }
                case "1":
                {
                    model.setLevel(1);
                    break;
                }
                case "2":
                {
                    model.setLevel(2);
                    break;
                }
                case "3":
                {
                    model.setLevel(3);
                    break;
                }
                case "4":
                {
                    model.setLevel(4);
                    break;
                }
                case "5":
                {
                    model.setLevel(5);
                    break;
                }
                case "6":
                {
                    model.setLevel(6);
                    break;
                }
                case "7":
                {
                    model.setLevel(7);
                    break;
                }
                case "8":
                {
                    model.setLevel(8);
                    break;
                }
                case "9":
                {
                    model.setLevel(9);
                    break;
                }
                case "MAX":
                {
                    model.setLevel(10);
                    break;
                }

            }
            displayBoard();
            displayNextShapeBoard();
            view.revalidate();
            view.repaint();
        }
    }

}
