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
        System.out.println("Click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Press");
        mousePressX = e.getX();
        mousePressY = e.getY();

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
}
