import javax.swing.*;
import java.awt.*;

public class PlayerScoreBoard extends JPanel {
    private int playerPoints;
    private int timer;
    private Window window;
    private static final long startTime = System.currentTimeMillis();

    public PlayerScoreBoard(Window window)
    {
        playerPoints = 0;
        timer = 5;
        this.window = window;
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setPaint(Color.black);
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 50));
        int actualWidth = graphics2D.getFontMetrics().stringWidth(String.valueOf(playerPoints));
        graphics2D.drawString(String.valueOf(playerPoints), window.getWidth() - actualWidth - 50, 100);

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

}
