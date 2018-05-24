import TetrisControler.TetrisControler;

public class Main {

    public static void main(String[] args) {
        System.out.println("Tu powstanie Tetris");
        TetrisControler controller = new TetrisControler();
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    }
}
