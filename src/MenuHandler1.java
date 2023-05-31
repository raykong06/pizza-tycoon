import javax.swing.*;
import java.awt.*;

public class MenuHandler1 extends JFrame {
    private Window window;

    public MenuHandler1(Window window)
    {
        this.window = window;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setPaint(Color.WHITE);
        graphics2D.setFont(new Font("Ravie", Font.PLAIN, 76));
        int actualWidth = graphics2D.getFontMetrics().stringWidth("Snow Surfer");
        graphics2D.drawString("Snow Surfer", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("Snow Surfer") / 2), 200);
    }
}
