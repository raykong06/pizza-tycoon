import java.awt.*;

public class Player {

    private double x;
    private double y;
    private int width;
    private int height;

    private double velX;
    private double velY;
    private double jumpVel;
    private double gravity;
    private int speed;

    public Player(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        gravity = 4;
        jumpVel = 4;
        speed = 2;
    }

    public void tick()
    {
        x += velX;

        if (y + velY < 500)
        {
            y += velY;
        }

        if (velY < gravity)
        {
            velY += 0.1;
        }

    }

    public void render(Graphics graphics)
    {
        graphics.setColor(Color.red);
        graphics.fillRect((int)x, (int)y, width, height);
    }

    public void setVelX(double newVel)
    {
        velX = newVel;
    }

    public void setVelY(double newVel)
    {
        velY = newVel;
    }

    public double getJumpVel()
    {
        return jumpVel;
    }

    public int getSpeed()
    {
        return speed;
    }
}
