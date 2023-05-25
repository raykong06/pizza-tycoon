import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends JPanel{

    private double x;
    private double y;
    private int width;
    private int height;

    private double velX;
    private double velY;
    private double jumpVel;
    private double gravity;
    private int speed;
    private ImageIcon motion1;
    private ImageIcon motion2;
    private ImageIcon motion3;
    private ImageIcon motion4;
    private ImageIcon motion5;
    private ImageIcon motion6;
    private ArrayList<ImageIcon> imgArr;
    private ImageIcon display;
    private int spriteCounter;
    private int spriteNum;
    private PlayerScoreBoard playerScoreBoard = new PlayerScoreBoard();

    public Player(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        gravity = 4;
        jumpVel = 10;
        speed = 4;

        motion1 = new ImageIcon("img/player_motion1.png");
        motion2 = new ImageIcon("img/player_motion2.png");
        motion3 = new ImageIcon("img/player_motion3.png");
        motion4 = new ImageIcon("img/player_motion4.png");
        motion5 = new ImageIcon("img/player_motion5.png");
        motion6 = new ImageIcon("img/player_motion6.png");
        display = motion1;

        imgArr = new ArrayList<ImageIcon>();
        imgArr.add(motion1);
        imgArr.add(motion2);
        imgArr.add(motion3);
        imgArr.add(motion4);
        imgArr.add(motion5);
        imgArr.add(motion6);

        spriteCounter = 0;
        spriteNum = 0;
    }

    public void tick()
    {
        x += velX;

        if (velY < gravity)
        {
            velY += 0.45;
        }

        if (y + velY < 300)
        {
            y += velY;
        }
        else
        {
            velY = 0;
        }
    }

    public void paintComponent(Graphics graphics)
    {
        display = imgArr.get(spriteNum);
        super.paintComponent(graphics);
        display.paintIcon(this, graphics, (int)x, (int)y);
        playerScoreBoard.paintComponent(graphics);

        //graphics.setColor(Color.red);
        //graphics.fillRect((int)x, (int)y, width, height);

        spriteCounter++;
        if (spriteNum == 1 && spriteCounter > 12)
        {
            spriteNum++;
            spriteCounter = 0;
        }
        else if (spriteNum == 0 && spriteCounter > 12)
        {
            spriteNum++;
            spriteCounter = 0;
        }
        else if (spriteNum > 1 && spriteCounter > 12)
        {
            if (spriteNum < 5)
            {
                spriteNum++;
            }
            else
            {
                spriteNum = 0;
            }
            spriteCounter = 0;
        }
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

    public PlayerScoreBoard getPlayerScoreBoard()
    {
        return playerScoreBoard;
    }
}
