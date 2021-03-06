package TetrisModel;

import java.util.*;

/**
 * abstract class, every Tetris shape in the game inherits after this class
 *        blockSet      przechowuje bloki skladajace sie na aktualny ksztalt tetrominoe
 *        state         tells about state of shape
 *                      0 - vertically, up
 *                      1 - horizontally, right
 *                      2 - vertically, down
 *                      3 - horizontally, left
 */

public abstract class TetrisShape implements TetrisShapeInterface {
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    private ArrayList<Block> blockSet;
    int state;

    TetrisShape(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int color)
    {
        blockSet = new ArrayList<>();
        blockSet.add(0, new Block(x1, y1, color));
        blockSet.add(1, new Block(x2, y2, color));
        blockSet.add(2, new Block(x3, y3, color));
        blockSet.add(3, new Block(x4, y4, color));
        state = UP;
    }

    void setBlockX(int x, int number)
    {
        //catch exception number nalezy od 0 do 3
        blockSet.get(number).setPositionX(x);
    }


    void setBlockY(int y, int number)
    {
        //catch exception number nalezy od 0 do 3
        blockSet.get(number).setPositionY(y);
    }


    void setBlockXY(int x, int y, int number)
    {
        //catch exception number nalezy od 0 do 3
        blockSet.get(number).setPositionXY(x, y);
    }


    void setBlockColor(int color, int number)
    {
        //catch exception number nalezy od 0 do 3
        blockSet.get(number).setColorImage(color);
    }


    public int getBlockX(int number)
    {
        return blockSet.get(number).getPositionX();
    }


    public int getBlockY(int number)
    {
        return blockSet.get(number).getPositionY();
    }


    public int getBlockColor(int number)
    {
        return blockSet.get(number).getColorImage();
    }


    public int getNumberOfBlocks()
    {
        return this.blockSet.size();
    }


    public Block getBlock(int number)
    {
        return this.blockSet.get(number);
    }


    public void removeBlock(int number)
    {
        this.blockSet.remove(number);
    }


    @Override
    public void rotateLeft() {}
    @Override
    public void rotateRight() {}

    @Override
    public Block getHighestBlock(TetrisShape shape){
        //getHighestBlock gets Block that is in the 'left corner' of the shape
        //that is important in order to set rotated shape in good direction
        int numberOfBlock = 0;
        int tmpLine = TetrisModel.getHEIGHT();
        int tmpRow = TetrisModel.getWIDTH();
        for (int i = 0 ; i < shape.getNumberOfBlocks(); i++)
        {
            if( this.getBlock(i).getPositionY() < tmpLine )
            {
                tmpLine = this.getBlock(i).getPositionY();
                tmpRow = this.getBlock(i).getPositionX();
                numberOfBlock = i;
            }
            else if( this.getBlock(i).getPositionY() == tmpLine && this.getBlock(i).getPositionX() < tmpRow)
            {
                tmpRow = this.getBlock(i).getPositionX();
                numberOfBlock = i;
            }
        }
        return this.getBlock(numberOfBlock);
    }

    public boolean isEqual(TetrisShape shape)
    {
        //checks if Tetris Shape are equal
        int i = 0;
        boolean equal = true;
        if(shape == null){
            equal = false;
            return equal;
        }
        while(i < blockSet.size())
        {
            if(blockSet.get(i).getPositionX() != shape.getBlock(i).getPositionX()
                    || blockSet.get(i).getPositionY() != shape.getBlock(i).getPositionY()
                    || blockSet.get(i).getColorImage() != shape.getBlock(i).getColorImage())
            {
                equal = false;
            }
            i++;
        }
        return equal;
    }
}

