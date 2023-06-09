import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

public class MenuHandler extends JPanel{
    private Window window;
    private boolean settingsDialog;

    public MenuHandler(Window window)
    {
        this.window = window;
        settingsDialog = false;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setPaint(Color.BLACK);
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 100));
        int actualWidth = graphics2D.getFontMetrics().stringWidth("Pizza Tycoon");
        graphics2D.drawString("Pizza Tycoon", window.getWidth() / 2 - (actualWidth / 2), 200);

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

        if (settingsDialog)
        {
            graphics2D.setPaint(new Color(45,41,45));
            graphics2D.fillRoundRect(275,125,700,500,50,50);

            graphics2D.setPaint(new Color(190,190,190));
            graphics2D.setFont(new Font("Courier", Font.BOLD, 50));
            graphics2D.drawString("Difficulty", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("Difficulty") / 2), 250);

            // Exit Button
            graphics2D.setPaint(new Color(190,190,190));
            graphics2D.fillRoundRect(window.getWidth() / 2 - 150,425,300,125,50,50);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.drawRoundRect(window.getWidth() / 2 - 150,425,300,125,50,50);
            graphics2D.setPaint(new Color(45,41,45));
            graphics2D.setFont(new Font("Courier", Font.BOLD, 32));
            graphics2D.drawString("Main", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("Main") / 2), 475);
            graphics2D.drawString("Menu", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("Main") / 2), 525);

            graphics2D.setPaint(new Color(214, 158, 4));
            graphics2D.fillRoundRect(350,300,150,100,25,25);
            graphics2D.fillRoundRect(750,300,150,100,25,25);

            graphics2D.setPaint(Color.BLACK);
            graphics2D.setFont(new Font("Courier", Font.BOLD, 72));
            graphics2D.drawString("-", 350 + 60, 375);
            graphics2D.drawString("+", 750 + 60, 375);

            graphics2D.drawRoundRect(350,300,150,100,25,25);
            graphics2D.drawRoundRect(750,300,150,100,25,25);

            graphics2D.setPaint(new Color(214, 158, 4));
            graphics2D.drawString(String.valueOf(window.getGameArea().getSpeed()), window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth(String.valueOf(window.getGameArea().getSpeed())) / 2), 375);
        }
    }

    public boolean isSettingsDialog() {
        return settingsDialog;
    }

    public void setSettingsDialog(boolean settingsDialog) {
        this.settingsDialog = settingsDialog;
    }

}
