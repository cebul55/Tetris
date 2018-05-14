package TetrisModel;

 class TetrisShape_O extends TetrisShape {
    TetrisShape_O()
    {
        super(  (TetrisModel.getWIDTH()-2)/2,       0,
                (TetrisModel.getWIDTH()-2)/2,       1,
                (TetrisModel.getWIDTH()-2)/2 + 1,   0,
                (TetrisModel.getWIDTH()-2)/2 + 1,   1,
                0
        );
    }

     @Override
     public void rotateLeft() {}

     @Override
     public void rotateRight() {}
}
