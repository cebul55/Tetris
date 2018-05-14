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
