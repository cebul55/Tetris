package TetrisModel;

/**
 * Block - definiuje pojedynczy blok, z ktorego skladaja sie wszystkie ksztalty Tetrominoes
 * @param positionX     wspolrzedna X
 * @param positionY     wspolrzedna Y
 * @param textureImage  kolor danego bloku oznaczony jako liczba
 */

class Block {
    private int positionX;
    private int positionY;
    private int colorImage;

    public Block(int posX, int posY, int color)
    {
        this.positionX = posX;
        this.positionY = posY;
        this.colorImage = color;
    }

    int getPositionX()
    {
        return positionX;
    }

    void setPositionX(int posX)
    {
        this.positionX = posX;
    }
    int getPositionY()
    {
        return positionY;
    }
    void setPositionY(int posY)
    {
        this.positionY = posY;
    }
    int getColorImage()
    {
        return colorImage;
    }
    void setColorImage(int texture)
    {
        this.colorImage = texture;
    }
    void setPositionXY(int posX, int posY)
    {
        this.positionX = posX;
        this.positionY = posY;
    }
}
