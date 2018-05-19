package TetrisModel;

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
