package TetrisModel;

/**
 * Speed class is used to count and store level,
 * speed[] Array contains possible times with TetrisShape is moved down during Game
 */

public class Speed {

    private final long speed[];
    private int level;

    Speed()
    {
        speed = new long[11];
        level = 1;

        speed[1] = 1000L;
        speed[2] = 900L;
        speed[3] = 800L;
        speed[4] = 700L;
        speed[5] = 600L;
        speed[6] = 500L;
        speed[7] = 400L;
        speed[8] = 300L;
        speed[9] = 250L;
        speed[10] = 200L;
    }

    public void levelUp()
    {
        if(level < 10 )
            this.level++;
    }
    long getSpeed()
    {
        return speed[this.level];
    }

    int getLevel()
    {
        return this.level;
    }

    void setLevel(int i)
    {
        if(i < 1 || i > 10)
        {
            level = 1;
        }
        else
            level = i;
    }
}
