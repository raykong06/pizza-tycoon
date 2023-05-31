import javax.swing.*;
import java.awt.*;

public class MenuHandler1 extends JPanel {
    private Window window;

    public MenuHandler1(Window window)
    {
        this.window = window;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setPaint(Color.black);
    }
}
