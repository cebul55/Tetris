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
    private TetrisModel tetrisModel;

    private int[] numberOfBlocksInTheRow;

    public LineCleaner(int rows, int columns, TetrisModel model)
    {
        numberOfRows = rows;
        numberOfColumns = columns;
        tetrisModel = model;

        numberOfBlocksInTheRow = new int[rows];
        for(int i = 0 ; i < rows; i++)
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

        cleanLine(y1, tetrisModel.getShapesOnBoard());
        cleanLine(y2, tetrisModel.getShapesOnBoard());
        cleanLine(y3, tetrisModel.getShapesOnBoard());
        cleanLine(y4, tetrisModel.getShapesOnBoard());
    }

    boolean checkIfRowHasToBeCleaned(int numberofRow)
    {
        return numberOfBlocksInTheRow[numberofRow] == numberOfColumns;
    }

    void setNumberOfBlocksInCleanedRowToZero(int row)
    {
        numberOfBlocksInTheRow[row] = 0;
    }

    int getNumberOfCleanedBlocks(int row)
    {
        return numberOfBlocksInTheRow[row];
    }

    void cleanLine(int numberOfCleanedRow , ArrayList<TetrisShape> shapesOnTheBoard)
    {
        if(checkIfRowHasToBeCleaned(numberOfCleanedRow) )
        {
            tetrisModel.addToScore(this.getNumberOfCleanedBlocks(numberOfCleanedRow));
            setNumberOfBlocksInCleanedRowToZero(numberOfCleanedRow);
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
                //TODO change deleting shapes
//                if(shape.getNumberOfBlocks() == 0)
//                    removeEmptyShapeFromArray( shapesOnTheBoard ,shapesOnTheBoard.indexOf(shape) );
            }
            removeEmptyShapes();
            moveEverythingDown(numberOfCleanedRow, shapesOnTheBoard);
        }
    }
    private void removeEmptyShapes()
    {
        TetrisShape shape;
        int size = tetrisModel.getNumberOfShapes();
        for(int i = size -1 ; i >= 0 ; i--)
        {
            shape = tetrisModel.getShapeFromIndex(i);
            if(shape.getNumberOfBlocks() == 0)
                removeEmptyShapeFromArray(tetrisModel.getShapesOnBoard() , i);
        }
    }

    void moveEverythingDown( int numberOfCleanedRow, ArrayList<TetrisShape> shapesOnTheBoard)
    {
        int currentRow;
        for( TetrisShape shape : shapesOnTheBoard )
        {
            for(int i = 0 ; i < shape.getNumberOfBlocks(); i++)
            {
                currentRow = shape.getBlockY(i);
                if(currentRow < numberOfCleanedRow)
                {
                    shape.setBlockY(shape.getBlockY(i)+1 , i);

                    changeStateOfBlocksInTheRow(currentRow);
                }
            }
        }
        changeStateOfTetrisBoard( numberOfCleanedRow , tetrisModel.getTetrisBoard() );
    }

    void changeStateOfBlocksInTheRow(int row)
    {
        numberOfBlocksInTheRow[row]--;
        numberOfBlocksInTheRow[row + 1]++;
    }

    void changeStateOfTetrisBoard(int row, boolean[][] tetrisBoard)
    {
        //update boolean[][] TetrisBoard

        for(int i = 0 ; i < numberOfColumns ; i++)
        {
            tetrisBoard[row][i] =false;
        }
        for(int tmpRow = row - 1 ; tmpRow >= 0; tmpRow--)
        {
            for(int column = 0; column < numberOfColumns; column++)
            {
                tetrisBoard[tmpRow + 1][column]=tetrisBoard[tmpRow][column];
                tetrisBoard[tmpRow][column] = false;
            }
        }
    }

    void removeEmptyShapeFromArray(ArrayList<TetrisShape> shapesOnTheBoard, int index )
    {
        shapesOnTheBoard.remove(index);
    }

    void printStateOfLines()
    {
        for(int i = 0; i < numberOfRows; i++)
        {
            System.out.println(i + " " + numberOfBlocksInTheRow[i] );
        }
    }
    //TODO fix counting blocks in line
}
