package TetrisModel;

 class TetrisShape_T extends TetrisShape{
    TetrisShape_T()
    {
        super(  (TetrisModel.getWIDTH()-2)/2,        0,
                (TetrisModel.getWIDTH()-2)/2,       1,
                (TetrisModel.getWIDTH()-2)/2 + 1,   1,
                (TetrisModel.getWIDTH()-2)/2,       2,
                0
        );
    }
}
