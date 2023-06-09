import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class PlayerScoreBoard extends JPanel {
    private int playerPoints;
    private int pizzasMade;
    private int livesLeft;
    private int timer;
    private Window window;
    private static long startTime = System.currentTimeMillis();

    public PlayerScoreBoard(Window window)
    {
        playerPoints = 5000000;
        pizzasMade = 5000;
        livesLeft = 2;
        timer = 60;
        this.window = window;
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        int displayTopCornerX = window.getWidth() - 500;
        int displayTopCornerY = 50;
        // Display Scoreboard
        graphics2D.setPaint(new Color(193,202,218));
        graphics2D.fillRoundRect(displayTopCornerX,displayTopCornerY,450,250,30,20);
        graphics2D.setPaint(new Color(255,255,255));
        graphics2D.fillRoundRect(displayTopCornerX + 10,displayTopCornerY + 10,430,230,30,15);

        // Pizza Info
        graphics2D.setPaint(new Color(10,67,124));
        graphics2D.setFont(new Font("Courier New", Font.BOLD,20));
        graphics2D.drawString("Cheese Pizza", displayTopCornerX + 25, displayTopCornerY + 40);

        // Player Info
        graphics2D.setPaint(new Color(241,243,244));
        graphics2D.fillRoundRect(displayTopCornerX + 260,displayTopCornerY + 20,170,100,30,15);
        graphics2D.setPaint(new Color(64,65,64));
        graphics2D.setFont(new Font("Courier New", Font.BOLD,14));
        graphics2D.drawString("POINTS",displayTopCornerX + 270,displayTopCornerY + 40);
        int actualWidth = graphics2D.getFontMetrics().stringWidth(String.valueOf(playerPoints));
        graphics2D.drawString(String.valueOf(playerPoints),displayTopCornerX + 420 - actualWidth,displayTopCornerY + 40);
        graphics2D.drawString("PIZZAS MADE",displayTopCornerX + 270,displayTopCornerY + 60);
        actualWidth = graphics2D.getFontMetrics().stringWidth(String.valueOf(pizzasMade));
        graphics2D.drawString(String.valueOf(pizzasMade),displayTopCornerX + 420 - actualWidth,displayTopCornerY + 60);

        graphics2D.setPaint(new Color(196,0,54));
        graphics2D.setStroke(new BasicStroke(3));
        for (int i = 0; i < 3; i++)
        {
            Path2D heartPath = drawHeartPath(displayTopCornerX + 280 + (i * 50),displayTopCornerY + 80,30,30);
            graphics2D.draw(heartPath);
        }
        for (int i = 0; i < livesLeft; i++)
        {
            Path2D heartPath = drawHeartPath(displayTopCornerX + 280 + (i * 50),displayTopCornerY + 80,30,30);
            graphics2D.fill(heartPath);
        }

        /*
        graphics2D.setPaint(Color.black);
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 50));
        int actualWidth = graphics2D.getFontMetrics().stringWidth(String.valueOf(playerPoints));
        graphics2D.drawString(String.valueOf(playerPoints), window.getWidth() - actualWidth - 50, 100);
         */

        long elapsedTime = getTimeElapsed();
        if (timer - elapsedTime <= 0)
        {
            graphics2D.drawString("0:00", 50, 100);
            graphics2D.setPaint(Color.red);
            graphics2D.setFont(new Font("Oswald", Font.BOLD, 75));
            graphics2D.drawString("GAME OVER", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("GAME OVER") / 2), 275);
        }
        else if (timer - elapsedTime < 10)
        {
            graphics2D.drawString("0:0" + (int)(timer - elapsedTime), 50, 100);
        }
        else
        {
            graphics2D.drawString("0:" + (int)(timer - elapsedTime), 50, 100);
        }
    }

    public long getTimeElapsed()
    {
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    public void setStartTime()
    {
        startTime = System.currentTimeMillis();
    }

    // Draw a heart
    private Path2D drawHeartPath(float x, float y, float width, float height) {
        float beX = x + width / 2;  // bottom endpoint X
        float beY = y + height;     // bottom endpoint Y

        float c1DX = width  * 0.968f;  // delta X of control point 1
        float c1DY = height * 0.672f;  // delta Y of control point 1
        float c2DX = width  * 0.281f;  // delta X of control point 2
        float c2DY = height * 1.295f;  // delta Y of control point 2
        float teDY = height * 0.850f;  // delta Y of top endpoint

        Path2D.Float heartPath = new Path2D.Float();
        heartPath.moveTo(beX, beY);       // bottom endpoint
        // left side of heart
        heartPath.curveTo(
                beX - c1DX, beY - c1DY,   // control point 1
                beX - c2DX, beY - c2DY,   // control point 2
                beX       , beY - teDY);  // top endpoint
        // right side of heart
        heartPath.curveTo(
                beX + c2DX, beY - c2DY,   // control point 2
                beX + c1DX, beY - c1DY,   // control point 1
                beX       , beY);         // bottom endpoint
        return heartPath;
    }
}
