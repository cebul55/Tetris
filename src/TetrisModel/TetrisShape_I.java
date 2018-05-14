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
    private int x_pos = (TetrisModel.getWIDTH()-4) / 2;
    private int y_pos = 0;
    private int texture = 0;

    TetrisShape_I()
    {
        //super(x_pos, y_pos, x_pos + 1, y_pos, x_pos + 2, y_pos, x_pos + 3, y_pos, texture );
        super(  (TetrisModel.getWIDTH()-4)/2,       0,
                (TetrisModel.getWIDTH()-4)/2 + 1,   0,
                (TetrisModel.getWIDTH()-4)/2 + 2, 0,
                (TetrisModel.getWIDTH()-4)/2 + 3, 0,
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
