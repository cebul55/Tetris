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
