package TetrisController;

import TetrisModel.TetrisModel;
import TetrisView.TetrisView;

/**
 * TetrisController-klasa sluzaca do komunikacji pomiedzy modelem i widokiem. Rejestruje przekazane przez widok akcje uzytokwnika
 * oraz wysyla do widoku zmiany dokonana przez model.
 */

public class TetrisController {
    private TetrisModel model;
    private TetrisView view;

    public TetrisController()
    {
        model = new TetrisModel();
        view = new TetrisView();
        view.setVisible(true);
    }
}
