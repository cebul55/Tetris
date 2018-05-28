package TetrisModel;

/**
 * TetrisShapeInterface is used to implement rotate methods by different shapes
 */

interface TetrisShapeInterface {
    void rotateLeft();
    void rotateRight();
    Block getHighestBlock(TetrisShape shape);
}
