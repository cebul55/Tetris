package TetrisModel;

import java.util.*;

/**
 * Super class of every Tetris shape in the game
 */

public class TetrisShape {
    //TODO implement shape , skladajacy sie z blokwo
    private ArrayList<Block> blockSet;

    TetrisShape(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int texture)
    {
        blockSet.add(0, new Block(x1, y1, texture));
        blockSet.add(1, new Block(x2, y2, texture));
        blockSet.add(2, new Block(x3, y3, texture));
        blockSet.add(3, new Block(x4, y4, texture));
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

    void setBlockTexture(int texture, int number)
    {
        //catch exception number nalezy od 0 do 3
        blockSet.get(number).setTextureImage(texture);
    }
    int getBlockX(int number)
    {
        return blockSet.get(number).getPositionX();
    }
    int getBlockY(int number)
    {
        return blockSet.get(number).getPositionY();
    }
    int getBlockTexture(int number)
    {
        return blockSet.get(number).getTextureImage();
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
    public boolean isEqual(TetrisShape shape)
    {
        int i = 0;
        boolean equal = true;
        //TODO check if isEqual works correctly
        while(i < blockSet.size())
        {
            if(blockSet.get(i).getPositionX() != shape.getBlock(i).getPositionX()
                    || blockSet.get(i).getPositionY() != shape.getBlock(i).getPositionY()
                    || blockSet.get(i).getTextureImage() != shape.getBlock(i).getTextureImage())
            {
                equal = false;
            }
            i++;
        }
        return equal;
    }
}

