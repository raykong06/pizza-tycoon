import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private Thread thread;
    private boolean running;

    private Player player;
    private KeyInput keyInput;
    private LevelHandler levelHandler;
    private MenuHandler1 menuHandler1;
    private int gameState;
    //private JLabel imageLabel;

    // Runs everytime a new window is created
    public Window(String title)
    {
        running = false;
        keyInput = new KeyInput(this);
        levelHandler = new LevelHandler();
        menuHandler1 = new MenuHandler1(this);
        gameState = 1;

        JFrame frame = new JFrame(title);

        // sets frame size
        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // makes the frame visible and sets frame properties
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(this);

        player = new Player(this);
    }

    // Start the game
    public void start()
    {
        running = true;

        // Create new thread
        thread = new Thread(this);
        thread.start();
    }

    // Stop the game
    public void stop()
    {
        running = false;

        // stop the thread
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
                tick();
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

    // updates the window
    public void tick(){
        player.tick();
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
            graphics.setColor(Color.white);
            graphics.fillRect(0,0, this.getWidth(), this.getHeight());
            player.paintComponent(graphics);
        }
        else if (gameState == 2)
        {
            graphics.setColor(new Color(77, 110, 122));
            graphics.fillRect(0,0, this.getWidth(), this.getHeight());
            menuHandler1.paintComponent(graphics);
        }
        else if (gameState == 3)
        {
            player.paintComponent(graphics);
        }

        bs.show();
        graphics.dispose();
    }

    public Player getPlayer()
    {
        return player;
    }
}
