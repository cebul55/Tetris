package TetrisModel;

import java.util.ArrayList;

/**
 * class LineCleaner
 *     private int[] numberOfBlocksInTheRow -> stores actual number of blocks in the row
 *
 *     LineCleaner removes whole lines and moves down everything what is above removed line
 */

class LineCleaner {
    private static int numberOfRows;
    private static int numberOfColumns;

    private int[] numberOfBlocksInTheRow;

    public LineCleaner(int rows, int columns)
    {
        numberOfRows = rows;
        numberOfColumns = columns;

        //array's size is rows + 1 in order to use row numbers; numberOfBlockInTheRow[0] is not used
        numberOfBlocksInTheRow = new int[rows + 1];
        for(int i = 0 ; i <= rows; i++)
        {
            numberOfBlocksInTheRow[i] = 0;
        }
    }

    int getNumberOfBlocksInTheRow(int i)
    {
        return numberOfBlocksInTheRow[i];
    }

    void shapeIsSettled( int y1,  int y2, int y3,  int y4)
    {
        numberOfBlocksInTheRow[y1]++;
        numberOfBlocksInTheRow[y2]++;
        numberOfBlocksInTheRow[y3]++;
        numberOfBlocksInTheRow[y4]++;
    }

    boolean checkIfRowHasToBeCleaned(int numberofRow)
    {
        return numberOfBlocksInTheRow[numberofRow] == numberOfColumns;
    }

    void cleanLine(int numberOfCleanedRow , ArrayList<TetrisShape> shapesOnTheBoard)
    {
        if(checkIfRowHasToBeCleaned(numberOfCleanedRow) )
        {
            for (TetrisShape shape : shapesOnTheBoard)
            {
                for (int i = 0 ; i < shape.getNumberOfBlocks() ; i++)
                {
                    if(shape.getBlockY(i) == numberOfCleanedRow)
                    {
                        shape.removeBlock(i);

                        //restarting loop in order to properly remove every block
                        i = 0;
                    }
                }
                if(shape.getNumberOfBlocks() == 0)
                    removeEmptyShapeFromArray( shapesOnTheBoard ,shapesOnTheBoard.indexOf(shape) );

            }
        }
    }

    void moveEverythingDown( int numberOfCleanedRow)
    {

    }



    void removeEmptyShapeFromArray(ArrayList<TetrisShape> shapesOnTheBoard, int index )
    {
        shapesOnTheBoard.remove(index);
    }

    //TODO work on LineCleaner
}
