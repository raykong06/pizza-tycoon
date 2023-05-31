import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends JPanel{

    private double xCoord;
    private double yCoord;

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
    private ImageIcon background;
    private ArrayList<ImageIcon> imgArr;
    private ImageIcon display;
    private int spriteCounter;
    private int spriteNum;
    private PlayerScoreBoard playerScoreBoard;
    private Window window;

    public Player(Window window)
    {
        this.window = window;
        xCoord = window.getWidth() / 2.0;
        yCoord = window.getHeight() / 2.0;
        playerScoreBoard = new PlayerScoreBoard(window);

        gravity = 4;
        jumpVel = 10;
        speed = 4;

        motion1 = new ImageIcon("img/player_motion1.png");
        motion2 = new ImageIcon("img/player_motion2.png");
        motion3 = new ImageIcon("img/player_motion3.png");
        motion4 = new ImageIcon("img/player_motion4.png");
        motion5 = new ImageIcon("img/player_motion5.png");
        motion6 = new ImageIcon("img/player_motion6.png");
        background = new ImageIcon("img/playerbackground.jpg");
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
        xCoord += velX;

        if (velY < gravity)
        {
            velY += 0.45;
        }

        if (yCoord + velY < window.getHeight() / 2.0)
        {
            yCoord += velY;
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
        background.paintIcon(this, graphics, 0, 0);
        display.paintIcon(this, graphics, (int)xCoord, (int)yCoord);
        playerScoreBoard.paintComponent(graphics);


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
