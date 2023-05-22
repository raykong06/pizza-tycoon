import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    private TrickLibrary trickLibrary = new TrickLibrary();
    private PenguinMechanics penguinMechanics = new PenguinMechanics();
    private double startTime = 0;
    private boolean rightKeyPressed = false;
    private boolean upKeyPressed = false;

    private Window window;

    public KeyInput(Window window)
    {
        this.window = window;
        window.addKeyListener(this);
    }

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
            window.getPlayer().setVelX(4);
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

    public void detectTricks()
    {
    }
    public void inputTick()
    {
        penguinMechanics.tick();
    }
}
