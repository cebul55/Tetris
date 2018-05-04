package TetrisModel;

 class TetrisShape_J extends TetrisShape{
    TetrisShape_J(){
        super(  (TetrisModel.getWIDTH()-2)/2 + 1,       0,
                (TetrisModel.getWIDTH()-2)/2 + 1,       1,
                (TetrisModel.getWIDTH()-2)/2 + 1,       2,
                (TetrisModel.getWIDTH()-2)/2 ,          2,
                0
        );
    }
}
