import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    private ScoreFileWriter scoreFileWriter;
    private Thread thread;
    private boolean running;
    private JFrame frame;
    private GameArea gameArea;
    private MouseInput mouseInput;
    private MenuHandler menuHandler;
    private int gameState;

    // Runs everytime a new window is created
    public Window(String title)
    {
        scoreFileWriter = new ScoreFileWriter();
        running = false;
        gameArea = new GameArea(this);
        mouseInput = new MouseInput(this);
        menuHandler = new MenuHandler(this);
        gameState = 1;

        frame = new JFrame(title);

        // sets frame size
        frame.setSize(1250, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // makes the frame visible and sets frame properties
        frame.setResizable(true);
        frame.setVisible(true);
        frame.add(this);
    }

    // Start the game
    public void start()
    {
        running = true;

        // Create new thread
        thread = new Thread(this);
        thread.start();
    }

    // begins when start calls the run method
    // basic run method, dont need to know how it works
    @Override
    public void run()
    {
        // time from last iteration to now
        long lastTime = System.nanoTime();
        // ticks averaged out, trying to attempt?
        double amountofTicks = 60.0;
        // nanoseconds per tick
        double ns = 1000000000 / amountofTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while (running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1)
            {
                // updates at approx 60 ticks per second
                render();
                // frames is # of times rendered per second
                frames++;
                updates++;
                delta--;
            }
            // renders as fast as possible
            //render();

            // allows for frames per second, using the system timer
            // used for resetting the frames and updates
            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    // paints onto the window
    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null)
        {
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }
        Graphics graphics = bs.getDrawGraphics();

        if (gameState == 1)
        {
            graphics.setColor(new Color(202,129,87));
            graphics.fillRect(0,0, this.getWidth(), this.getHeight());
            menuHandler.paintComponent(graphics);
        }
        else if (gameState == 2)
        {
            graphics.setColor(Color.white);
            graphics.fillRect(0,0, this.getWidth(), this.getHeight());
            gameArea.paintComponent(graphics);
        }

        bs.show();
        graphics.dispose();
    }

    public GameArea getGameArea()
    {
        return gameArea;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }
}
