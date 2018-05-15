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
         switch (state)
         {
             case UP:
                 this.setLeft();
                 state = LEFT;
                 break;
             case RIGHT:
                 this.setUp();
                 state = UP;
                 break;
             case DOWN:
                 this.setRight();
                 state = RIGHT;
                 break;
             case LEFT:
                 this.setDown();
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
                 this.setRight();
                 state = RIGHT;
                 break;
             case RIGHT:
                 this.setDown();
                 state = DOWN;
                 break;
             case DOWN:
                 this.setLeft();
                 state = LEFT;
                 break;
             case LEFT:
                 this.setUp();
                 state = UP;
                 break;
         }
         //this.rotateLeft();
     }

     private void setUp()
     {
         Block tmpBlock = this.getHighestBlock(this);
         int x1 = tmpBlock.getPositionX();
         int y1 = tmpBlock.getPositionY();

         this.setBlockX(x1,0);
         this.setBlockY(y1,0);

         this.setBlockX(x1,1);
         this.setBlockY(y1 + 1,1);

         this.setBlockX(x1 + 1,2);
         this.setBlockY(y1 + 1,2);

         this.setBlockX(x1 ,3);
         this.setBlockY(y1 + 2 ,3);
     }
     private void setRight()
     {
         Block tmpBlock = this.getHighestBlock(this);
         int x1 = tmpBlock.getPositionX();
         int y1 = tmpBlock.getPositionY();

         this.setBlockX(x1,0);
         this.setBlockY(y1,0);

         this.setBlockX(x1 + 1,1);
         this.setBlockY( y1 ,1);

         this.setBlockX(x1 + 1 ,2);
         this.setBlockY(y1 + 1,2);

         this.setBlockX(x1 + 2,3);
         this.setBlockY( y1 ,3);
     }

     private void setDown()
     {
         Block tmpBlock = this.getHighestBlock(this);
         int x1 = tmpBlock.getPositionX();
         int y1 = tmpBlock.getPositionY();

         this.setBlockX(x1,0);
         this.setBlockY(y1,0);

         this.setBlockX(x1 ,1);
         this.setBlockY( y1 + 1 ,1);

         this.setBlockX(x1 - 1 ,2);
         this.setBlockY(y1 + 1,2);

         this.setBlockX(x1 ,3);
         this.setBlockY( y1 + 2 ,3);
     }

     private void setLeft()
     {
         Block tmpBlock = this.getHighestBlock(this);
         int x1 = tmpBlock.getPositionX();
         int y1 = tmpBlock.getPositionY();

         this.setBlockX(x1,0);
         this.setBlockY(y1,0);

         this.setBlockX(x1 -1 ,1);
         this.setBlockY( y1 + 1,1);

         this.setBlockX(x1  ,2);
         this.setBlockY(y1 + 1,2);

         this.setBlockX(x1 + 1,3);
         this.setBlockY( y1 + 1,3);
     }
 }
