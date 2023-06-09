import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

public class MouseInput implements MouseListener {
    private double startTime = 0;
    private boolean rightKeyPressed = false;
    private boolean upKeyPressed = false;

    private Window window;
    private GameArea gameArea;
    private int mousePressX;
    private int mousePressY;
    private int mouseReleaseX;
    private int mouseReleaseY;

    public MouseInput(Window window)
    {
        this.window = window;
        window.addMouseListener(this);

        gameArea = window.getGameArea();

        mousePressX = 0;
        mousePressY = 0;
        mouseReleaseX = 0;
        mouseReleaseY = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressX = e.getX();
        mousePressY = e.getY();

        if (window.getGameState() == 1)
        {
            if (mainMenuStartContains(mousePressX,mousePressY))
            {
                gameArea.reset();
                window.setGameState(2);
            }
            if (mainMenuQuitContains(mousePressX,mousePressY))
            {
                System.exit(0);
            }
        }

        if (window.getGameState() == 2)
        {
            if (tomatoSauceContains(mousePressX, mousePressY))
            {
                gameArea.setHoldingTomatoSauce(true);
            }
            else if (cheeseContains(mousePressX,mousePressY))
            {
                gameArea.setHoldingCheese(true);
            }
            else if (pepperoniContains(mousePressX,mousePressY))
            {
                gameArea.setHoldingPepperoni(true);
            }

            if (gameArea.getPlayerScoreBoard().getLivesLeft() <= 0)
            {
                if (gameOverButtonContains(mousePressX,mousePressY))
                {
                    window.setGameState(1);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseReleaseX = e.getX();
        mouseReleaseY = e.getY();

        if (releaseContains(gameArea.getPizzaX(), gameArea.getPizzaY()))
        {
            if (gameArea.isHoldingTomatoSauce())
            {
                gameArea.getCurrentPizza().setTomatoSauce(true);
            }
            if (gameArea.isHoldingCheese())
            {
                gameArea.getCurrentPizza().setCheese(true);
            }
            if (gameArea.isHoldingPepperoni())
            {
                gameArea.getCurrentPizza().setPepperoni(true);
            }
        }
        gameArea.setHoldingTomatoSauce(false);
        gameArea.setHoldingCheese(false);
        gameArea.setHoldingPepperoni(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private boolean releaseContains(int x, int y)
    {
        int radius = 90;
        return Point2D.distance(mouseReleaseX, mouseReleaseY, x, y) < radius;
    }

    private boolean tomatoSauceContains(int x, int y)
    {
        return (x > 135 && x < 185 && y > 280 && y < 380);
    }

    private boolean cheeseContains(int x, int y)
    {
        return (x > 310 && x < 500 && y > 360 && y < 430);
    }

    private boolean pepperoniContains(int x, int y)
    {
        return (x > 570 && x < 750 && y > 330 && y < 430);
    }

    private boolean gameOverButtonContains(int x, int y)
    {
        return (x > 475 && x < 775 && y > 400 && y < 525);
    }

    private boolean mainMenuStartContains(int x, int y)
    {
        return (x > 475 && x < 775 && y > 250 && y < 335);
    }

    private boolean mainMenuSettingsContains(int x, int y)
    {
        return (x > 475 && x < 775 && y > 375 && y < 460);
    }

    private boolean mainMenuQuitContains(int x, int y)
    {
        return (x > 475 && x < 775 && y > 500 && y < 585);
    }
}
