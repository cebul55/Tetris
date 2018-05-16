package TetrisModel;

import java.util.Random;

public class RandomShapeGenerator {
    private static Random random;
    private static int randomNumber;

    public RandomShapeGenerator()
    {
        random = new Random();
        this.setRandomNumber();
    }

    private void setRandomNumber()
    {
        randomNumber = random.nextInt(7);
    }

    public TetrisShape getTetrisShape(){
        this.setRandomNumber();
        if(randomNumber == 0)
            return new TetrisShape_I();
        else if(randomNumber == 1)
            return new TetrisShape_J();
        else if(randomNumber == 2)
            return new TetrisShape_L();
        else if(randomNumber == 3)
            return new TetrisShape_O();
        else if(randomNumber == 4)
            return new TetrisShape_S();
        else if(randomNumber == 5)
            return new TetrisShape_T();
        else
            return new TetrisShape_Z();
    }
}
