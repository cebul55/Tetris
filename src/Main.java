import TetrisController.TetrisController;
import TetrisModel.TetrisModel;
import TetrisView.TetrisView;

public class Main {

    public static void main(String[] args) {
        System.out.println("Tu powstanie Tetris");
        TetrisModel model = new TetrisModel();
        TetrisView view = new TetrisView();
        TetrisController controller = new TetrisController(model, view);
        view.setVisible(true);
        view.dispose();
        //TODO zmienic view w taki sposob aby z tego miejsca nie byly dostepne takie f-cje jak dispose
    }
}
