package TetrisModel;

 class TetrisShape_L extends TetrisShape {
    TetrisShape_L()
    {
        super(  (TetrisModel.getWIDTH()-2)/2,       0,
                (TetrisModel.getWIDTH()-2)/2,       1,
                (TetrisModel.getWIDTH()-2)/2,       2,
                (TetrisModel.getWIDTH()-2)/2 + 1,   2,
                0
        );
    }

     @Override
     public void rotateLeft()
     {
         System.out.println("TODO rotate");
     }

     @Override
     public void rotateRight()
     {
         System.out.println("TODO rotate");
     }
}
