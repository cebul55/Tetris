package TetrisModel;

/**Tetris Shape_O
 *
 *      **
 *      **
 */

 class TetrisShape_O extends TetrisShape {
    TetrisShape_O()
    {
        super(  (TetrisModel.getWIDTH()-2)/2,       0,
                (TetrisModel.getWIDTH()-2)/2,       1,
                (TetrisModel.getWIDTH()-2)/2 + 1,   0,
                (TetrisModel.getWIDTH()-2)/2 + 1,   1,
                3
        );
    }

     @Override
     public void rotateLeft()
     {
         switch (state)
         {
             case UP:
                 state = LEFT;
                 break;
             case RIGHT:
                 state = UP;
                 break;
             case DOWN:
                 state = RIGHT;
                 break;
             case LEFT:
                 state = DOWN;
                 break;
         }
     }

     @Override
     public void rotateRight()
     {
         switch (state)
         {
             case UP:
                 state = RIGHT;
                 break;
             case RIGHT:
                 state = DOWN;
                 break;
             case DOWN:
                 state = LEFT;
                 break;
             case LEFT:
                 state = UP;
                 break;
         }
         //this.rotateLeft();
     }
}
