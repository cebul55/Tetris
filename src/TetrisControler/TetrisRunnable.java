package TetrisControler;

import java.util.Date;
import java.util.concurrent.TimeUnit;


class TetrisRunnable implements Runnable {
    private long time;
    private TetrisControler controler;
    int i = 0;

    TetrisRunnable(long t, TetrisControler tetrisControler)
    {
        super();
        //time.setTime(t);
        time = t;
        controler = tetrisControler;
    }

    void setTime(long t)
    {
        //time.setTime(t);
        time = t;
    }

    public void run()
    {
        while (true) {
                //controler.moveDown();
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[])
    {
        (new TetrisRunnable(1000, new TetrisControler() )).run();
    }
}
