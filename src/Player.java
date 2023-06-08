import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
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
    private int pizzaX;
    private int pizzaY;

    public Player(Window window)
    {
        this.window = window;
        xCoord = 1000 / 2.0;
        yCoord = 750 / 2.0 - 50;
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

        pizzaX = -250;
        pizzaY = 525;
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
        //display = imgArr.get(spriteNum);
        super.paintComponent(graphics);
        //background.paintIcon(this, graphics, 0, 0);
        //display.paintIcon(this, graphics, (int)xCoord, (int)yCoord);
        playerScoreBoard.paintComponent(graphics);

        spriteCounter++;
        int speed = 3;

        if (spriteCounter * speed - 250 > 1306)
        {
            spriteCounter = 0;
        }

        Graphics2D graphics2D = (Graphics2D) graphics;

        // Conveyor Belt
        graphics2D.setPaint(new Color(198,198,198));
        graphics2D.fillRect(-100,500,1400,300);
        graphics2D.setPaint(new Color(156,156,156));
        int conveyorLineX = -1450 + (spriteCounter * speed);
        int conveyorLineGap = 130;
        graphics2D.setStroke(new BasicStroke(3));
            // bottom line
        graphics2D.drawLine(0, 700, 1250, 700);
            // Conveyor Belt Lines
        for (int i = 0; i < 25; i++)
        {
            graphics2D.drawLine(conveyorLineX + (conveyorLineGap * i), 500, conveyorLineX - 25 + (conveyorLineGap * i), 700);
        }

        // Stand


        // Pizza
        graphics2D.setPaint(new Color(244,203,146));
        graphics2D.fill(new Ellipse2D.Double(-250 + (spriteCounter * speed), 525, 200, 150));
        graphics2D.setStroke(new BasicStroke(10));
        graphics2D.setPaint(new Color(196,134,1));
        graphics2D.draw(new Ellipse2D.Double(-250 + (spriteCounter * speed), 525, 200, 150));
        pizzaX = -250 + (spriteCounter * speed) + 100;
        pizzaY = 525 + 75;


        /*
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

         */
    }

    public int getPizzaX() {
        return pizzaX;
    }

    public int getPizzaY() {
        return pizzaY;
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
