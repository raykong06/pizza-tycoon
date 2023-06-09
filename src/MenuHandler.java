import javax.swing.*;
import java.awt.*;

public class MenuHandler extends JPanel{
    private Window window;

    public MenuHandler(Window window)
    {
        this.window = window;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setPaint(Color.BLACK);
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 100));
        int actualWidth = graphics2D.getFontMetrics().stringWidth("Pizza Tycoon");
        graphics2D.drawString("Pizza Tycoon", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("Snow Surfer") / 2), 200);

        graphics2D.setPaint(new Color(190,190,190));
        graphics2D.fillRoundRect(475,250,300,85,50,50);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setPaint(Color.BLACK);
        graphics2D.drawRoundRect(475,250,300,85,50,50);
        graphics2D.setPaint(new Color(45,41,45));
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 32));
        graphics2D.drawString("Start Game", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("Start Game") / 2), 300);

        graphics2D.setPaint(new Color(190,190,190));
        graphics2D.fillRoundRect(475,375,300,85,50,50);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setPaint(Color.BLACK);
        graphics2D.drawRoundRect(475,375,300,85,50,50);
        graphics2D.setPaint(new Color(45,41,45));
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 32));
        graphics2D.drawString("Settings", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("Settings") / 2), 425);

        graphics2D.setPaint(new Color(190,190,190));
        graphics2D.fillRoundRect(475,500,300,85,50,50);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setPaint(Color.BLACK);
        graphics2D.drawRoundRect(475,500,300,85,50,50);
        graphics2D.setPaint(new Color(45,41,45));
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 32));
        graphics2D.drawString("Quit & Save", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("Quit & Save") / 2), 550);
    }
}
