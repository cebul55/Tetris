package TetrisModel;

 class TetrisShape_Z extends TetrisShape{
    TetrisShape_Z()
    {
        super(  (TetrisModel.getWIDTH()-2)/2 + 1,       0,
                (TetrisModel.getWIDTH()-2)/2 + 1,      1,
                (TetrisModel.getWIDTH()-2)/2 ,       1,
                (TetrisModel.getWIDTH()-2)/2 ,   2,
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
