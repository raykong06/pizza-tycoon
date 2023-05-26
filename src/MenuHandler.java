import javax.swing.JPanel;
import java.awt.*;

public class MenuHandler extends JPanel{

    private Window window;
    private int selectorX;
    private int selectorY;
    private byte selector;
    public MenuHandler(Window window)
    {
        this.window = window;
        selectorX = 0;
        selectorY = 0;
        selector = 0;
    }
    // used to render the menu
    public void paintComponent(Graphics graphics)
    {
        // Text
        super.paintComponent(graphics);
        graphics.setColor(Color.black);
        String title = "Snow Surfer";
        String startGame = "Start a New Game";
        String options = "Options";
        String exitGame = "Exit Game";

        graphics.setFont(new Font("Impact", Font.PLAIN, 50));
        graphics.drawString(title, window.getWidth() / 2 - (graphics.getFontMetrics().stringWidth(title) / 2), 100);

        graphics.setFont(new Font("Oswald", Font.PLAIN, 25));
        if (selector == 0)
        {
            selectorX = window.getWidth() / 2 - (graphics.getFontMetrics().stringWidth(startGame) / 2) - 64;
        }

        graphics.drawString(startGame, window.getWidth() / 2 - (graphics.getFontMetrics().stringWidth(startGame) / 2), 275);
        graphics.drawString(options, window.getWidth() / 2 - (graphics.getFontMetrics().stringWidth(options) / 2), 350);
        graphics.drawString(exitGame, window.getWidth() / 2 - (graphics.getFontMetrics().stringWidth(exitGame) / 2), 425);

        //
        graphics.setColor(Color.red);
        graphics.fillOval();
    }

    // used to update the menu
    public void tick()
    {

    }
}
