package TetrisControler;

import java.util.Date;


class TetrisThread extends Thread {
    Date time;
    TetrisThread(long t)
    {
        super();
        time.setTime(t);
    }
    public void run()
    {
        while (true) {
            System.out.println(time.getTime());
            //todo pausing thread or sth
        }
    }

    public static void main(String args[])
    {
        (new TetrisThread()).start();
    }
}
