import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

public class MouseInput implements MouseListener {
    private double startTime = 0;
    private boolean rightKeyPressed = false;
    private boolean upKeyPressed = false;

    private Window window;
    private GameArea gameArea;
    private boolean mouseInitialClick;
    private int mouseX;
    private int mouseY;

    public MouseInput(Window window)
    {
        this.window = window;
        window.addMouseListener(this);

        gameArea = window.getPlayer();

        mouseX = 0;
        mouseY = 0;
    }



    /*
    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("down");
                // handle down
                break;
            case KeyEvent.VK_LEFT:
                // handle left
                break;
            case KeyEvent.VK_RIGHT :
                // handle right
                break;
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            window.getPlayer().setVelX(window.getPlayer().getSpeed());
            rightKeyPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            window.getPlayer().setVelX(-window.getPlayer().getSpeed());
            rightKeyPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP && window.getPlayer().getVelY() == 0)
        {
            window.getPlayer().setVelY(-window.getPlayer().getJumpVel());
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            window.getPlayer().setVelY(1);
            upKeyPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        detectTricks();

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && rightKeyPressed)
        {
            window.getPlayer().setVelX(0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT && !rightKeyPressed)
        {
            window.getPlayer().setVelX(0);
        }
        //else if (e.getKeyCode() == KeyEvent.VK_UP && upKeyPressed)
        //{
        //    window.getPlayer().setVelY(0);
        //}
        else if (e.getKeyCode() == KeyEvent.VK_DOWN && !upKeyPressed)
        {
            window.getPlayer().setVelY(0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
        }
    }

     */

    public void detectTricks()
    {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Press");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Release");
        System.out.println(e.getX() + ", " + e.getY());
        mouseX = e.getX();
        mouseY = e.getY();

        if (contains(gameArea.getPizzaX(), gameArea.getPizzaY()))
        {
            gameArea.getCurrentPizza().setTomatoSauce(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean contains(int x, int y){
        int radius = 90;
        return Point2D.distance(mouseX, mouseY, x, y) < radius;
    }

}
