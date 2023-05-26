import javax.swing.JPanel;
import java.awt.*;

public class MenuHandler extends JPanel{

    private Window window;
    public MenuHandler(Window window)
    {
        this.window = window;
    }
    // used to render the menu
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        graphics.setColor(Color.black);
        String startGame = "Start a New Game";
        String optionGame = "Options";
        String exitGame = "Exit Game";
        FontMetrics fontMetrics = graphics.getFontMetrics(graphics.getFont());
        graphics.setFont(new Font("Oswald", Font.BOLD, 75));
        graphics.drawString("Start the Game!", window.getWidth() / 2 - (fontMetrics.stringWidth(startGame) / 2), 200);
        graphics.drawString("Options", window.getWidth() / 2 - (fontMetrics.stringWidth(optionGame) / 2), 350);
        graphics.drawString("Exit the Game!", window.getWidth() / 2 - (fontMetrics.stringWidth(exitGame) / 2), 500);
    }

    // used to update the menu
    public void tick()
    {

    }
}
