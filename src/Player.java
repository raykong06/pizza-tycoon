import java.awt.*;

public class Player {

    private int x;
    private int y;
    private int width;
    private int height;

    private int velX;
    private int velY;

    public Player(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void tick()
    {
        x += velX;
        y += velY;
    }

    public void render(Graphics graphics)
    {
        graphics.setColor(Color.red);
        graphics.fillRect(x, y, width, height);
    }

    public void setVelX(int newVel)
    {
        velX = newVel;
    }

    public void setVelY(int newVel)
    {
        velY = newVel;
    }
}
