package TetrisModel;

 class TetrisShape_Z extends TetrisShape{
    TetrisShape_Z()
    {
        super(  (TetrisModel.getWIDTH()-2)/2 + 1,       0,
                (TetrisModel.getWIDTH()-2)/2 + 1,      1,
                (TetrisModel.getWIDTH()-2)/2 ,       1,
                (TetrisModel.getWIDTH()-2)/2 ,   2,
                6
        );
    }

     @Override
     public void rotateLeft()
     {
         this.rotateRight();
     }

     @Override
     public void rotateRight()
     {
         switch (state)
         {
             case UP:
                 this.setHorizontally();
                 state = RIGHT;
                 break;
             case RIGHT:
                 this.setVertically();
                 state = DOWN;
                 break;
             case DOWN:
                 this.setHorizontally();
                 state = LEFT;
                 break;
             case LEFT:
                 this.setVertically();
                 state = UP;
                 break;
         }
         //this.rotateLeft();
     }

     private void setVertically()
     {
         Block tmpBlock = this.getHighestBlock(this);
         int x1 = tmpBlock.getPositionX();
         int y1 = tmpBlock.getPositionY();

         this.setBlockX(x1,0);
         this.setBlockY(y1,0);
         this.setBlockX(x1,1);
         this.setBlockY(y1 + 1,1);
         this.setBlockX(x1 - 1,2);
         this.setBlockY(y1 + 1,2);
         this.setBlockX(x1 - 1,3);
         this.setBlockY(y1 + 2,3);
     }
     private void setHorizontally()
     {
         Block tmpBlock = this.getHighestBlock(this);
         int x1 = tmpBlock.getPositionX();
         int y1 = tmpBlock.getPositionY();

         this.setBlockX(x1,0);
         this.setBlockY(y1,0);
         this.setBlockX(x1 + 1,1);
         this.setBlockY(y1 ,1);
         this.setBlockX(x1 + 1 ,2);
         this.setBlockY(y1 + 1,2);
         this.setBlockX(x1 + 2,3);
         this.setBlockY(y1 + 1,3);
     }

 }
