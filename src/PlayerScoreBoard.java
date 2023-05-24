import javax.swing.*;
import java.awt.*;

public class PlayerScoreBoard extends JPanel {
    private int playerPoints;
    private int timer;

    public PlayerScoreBoard()
    {
        playerPoints = 0;
        timer = 60;
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setPaint(Color.black);
        graphics2D.setFont(new Font("Oswald", Font.BOLD, 50));
        int actualWidth = graphics2D.getFontMetrics().stringWidth(String.valueOf(playerPoints));
        graphics2D.drawString(String.valueOf(playerPoints), 750 - actualWidth, 100);
    }
}
