package TetrisModel;

 class TetrisShape_S extends TetrisShape {
    TetrisShape_S()
    {
        super(  (TetrisModel.getWIDTH()-2)/2,       0,
                (TetrisModel.getWIDTH()-2)/2 ,      1,
                (TetrisModel.getWIDTH()-2)/2 + 1,       1,
                (TetrisModel.getWIDTH()-2)/2 + 1,   2,
                0
        );
    }
}
