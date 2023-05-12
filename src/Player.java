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
        jumpVel = 6;
        speed = 2;
    }

    public void tick()
    {
        x += velX;

        if (velY < gravity)
        {
            velY += 0.1;
        }

        if (y + velY < 500)
        {
            y += velY;
        }
        else
        {
            velY = 0;
        }
    }

    public void render(Graphics graphics)
    {
        graphics.setColor(Color.red);
        graphics.fillRect((int)x, (int)y, width, height);
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public double getJumpVel() {
        return jumpVel;
    }

    public int getSpeed() {
        return speed;
    }
}
