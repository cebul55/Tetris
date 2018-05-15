package TetrisModel;

/**
 * TetrisShape-I
 *      ---- -> vertical
 *
 *      I
 *      I    -> horizontal
 *      I
 *      I
 */
 class TetrisShape_I extends TetrisShape {
//    private int x_pos = (TetrisModel.getWIDTH()-4) / 2;
//    private int y_pos = 0;
//    private int texture = 0;

    TetrisShape_I()
    {
        //super(x_pos, y_pos, x_pos + 1, y_pos, x_pos + 2, y_pos, x_pos + 3, y_pos, texture );
        super(  (TetrisModel.getWIDTH()-4)/2,       0,
                (TetrisModel.getWIDTH()-4)/2 + 1,   0,
                (TetrisModel.getWIDTH()-4)/2 + 2, 0,
                (TetrisModel.getWIDTH()-4)/2 + 3, 0,
                0
                );
        state = UP;

    }

    @Override
    public void rotateLeft()
    {
        switch (state)
        {
            case UP:
                this.setVertically();
                state = LEFT;
                break;
            case RIGHT:
                this.setHorizontally();
                state = UP;
                break;
            case DOWN:
                this.setVertically();
                state = RIGHT;
                break;
            case LEFT:
                this.setHorizontally();
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
                this.setVertically();
                state = RIGHT;
                break;
            case RIGHT:
                this.setHorizontally();
                state = DOWN;
                break;
            case DOWN:
                this.setVertically();
                state = LEFT;
                break;
            case LEFT:
                this.setHorizontally();
                state = UP;
                break;
        }
        //this.rotateLeft();
    }

    private void setHorizontally()
    {
        Block tmpBlock = this.getHighestBlock(this);
        int x1 = tmpBlock.getPositionX();
        int y1 = tmpBlock.getPositionY();

        this.setBlockX(x1,0);
        this.setBlockY(y1,0);
        this.setBlockX(x1 + 1,1);
        this.setBlockY(y1,1);
        this.setBlockX(x1 + 2,2);
        this.setBlockY(y1,2);
        this.setBlockX(x1 + 3,3);
        this.setBlockY(y1,3);
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
        this.setBlockX(x1,2);
        this.setBlockY(y1 + 2,2);
        this.setBlockX(x1,3);
        this.setBlockY(y1 + 3,3);
    }
}
