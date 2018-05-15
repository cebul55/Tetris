package TetrisModel;

interface TetrisShapeInterface {
    void rotateLeft();
    void rotateRight();
    Block getHighestBlock(TetrisShape shape);
//    void setNorth(int x1, int y1);
//    void setEast(int x1, int y1);
//    void setSouth(int x1, int y1);
//    void setWest(int x1, int y1);
}
