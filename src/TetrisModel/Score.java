package TetrisModel;

/**
 * Score class used to count score in current Tetris game
 *
 * score is stored as Integer, every line that is cleaned is added to score as number of blocks in the line
 * or in other words the width of tetris board
 */

class Score {
    private int tetrisScore;
    private final int numberOfBlocksInTheLine;

    Score(int width)
    {
        tetrisScore = 0;
        numberOfBlocksInTheLine = width;
    }

    void setScoreToZero()
    {
        tetrisScore = 0;
    }

    void addScore()
    {
        tetrisScore += numberOfBlocksInTheLine;
    }

    int getTetrisScore()
    {
        return tetrisScore;
    }
}
