import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class PlayerScoreBoard extends JPanel {
    private int playerPoints;
    private int pizzasMade;
    private int livesLeft;
    private Window window;
    private final Pizza cheesePizza = new Pizza(true,true,false,false,false,false);
    private final Pizza pepperoniPizza = new Pizza(true,true,true,false,false,false);
    private final Pizza allInPizza = new Pizza(true,true,true,true,true,true);
    private final Pizza dryPizza = new Pizza(false,true,true,false,true,true);
    private final Pizza veganPizza = new Pizza(true,false,false,true,true,true);
    private Pizza currentPizza;
    private ImageIcon cheesePizzaImageIcon;
    private ImageIcon pepperoniPizzaImageIcon;
    private ImageIcon allInPizzaImageIcon;
    private ImageIcon dryPizzaImageIcon;
    private ImageIcon veganPizzaImageIcon;

    public PlayerScoreBoard(Window window)
    {
        playerPoints = 0;
        pizzasMade = 0;
        livesLeft = 3;
        this.window = window;

        cheesePizza.setName("Cheese Pizza");
        pepperoniPizza.setName("Pepperoni Pizza");
        allInPizza.setName("All In Pizza");
        dryPizza.setName("Dry Pizza");
        veganPizza.setName("Vegan Pizza");

        cheesePizzaImageIcon = new ImageIcon("img/cheese_pizza.png");
        pepperoniPizzaImageIcon = new ImageIcon("img/pepperoni_pizza.png");
        allInPizzaImageIcon = new ImageIcon("img/all_in_pizza.png");
        dryPizzaImageIcon = new ImageIcon("img/dry_pizza.png");
        veganPizzaImageIcon = new ImageIcon("img/vegan_pizza.png");

        generateRandomPizzaRecipe();
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        int displayTopCornerX = window.getWidth() - 500;
        int displayTopCornerY = 50;

        // Display Scoreboard
        graphics2D.setPaint(new Color(193,202,218));
        graphics2D.fillRoundRect(displayTopCornerX,displayTopCornerY,450,250,30,20);
        graphics2D.setPaint(new Color(255,255,255));
        graphics2D.fillRoundRect(displayTopCornerX + 10,displayTopCornerY + 10,430,230,30,15);

        // Pizza Info
        graphics2D.setPaint(new Color(10,67,124));
        graphics2D.setFont(new Font("Courier New", Font.BOLD,20));
        graphics2D.drawString(currentPizza.getName(), displayTopCornerX + 25, displayTopCornerY + 40);
        if (currentPizza.equals(cheesePizza))
        {
            cheesePizzaImageIcon.paintIcon(this,graphics2D,displayTopCornerX + 30,displayTopCornerY + 60);
        }
        if (currentPizza.equals(pepperoniPizza))
        {
            pepperoniPizzaImageIcon.paintIcon(this,graphics2D,displayTopCornerX + 30,displayTopCornerY + 60);
        }
        if (currentPizza.equals(allInPizza))
        {
            allInPizzaImageIcon.paintIcon(this,graphics2D,displayTopCornerX + 30,displayTopCornerY + 60);
        }
        if (currentPizza.equals(dryPizza))
        {
            dryPizzaImageIcon.paintIcon(this,graphics2D,displayTopCornerX + 30,displayTopCornerY + 60);
        }
        if (currentPizza.equals(veganPizza))
        {
            veganPizzaImageIcon.paintIcon(this,graphics2D,displayTopCornerX + 30,displayTopCornerY + 60);
        }

        int j = 0;
        if (currentPizza.isTomatoSauce())
        {
            graphics2D.setFont(new Font("Courier New", Font.BOLD,10));
            int actualWidth = graphics2D.getFontMetrics().stringWidth("Tomato Sauce");
            graphics2D.drawString("Tomato Sauce", displayTopCornerX + 420 - actualWidth, displayTopCornerY + 150 + (j * 15));
            j++;
        }
        if (currentPizza.isCheese())
        {
            graphics2D.setFont(new Font("Courier New", Font.BOLD,10));
            int actualWidth = graphics2D.getFontMetrics().stringWidth("Cheese");
            graphics2D.drawString("Cheese", displayTopCornerX + 420 - actualWidth, displayTopCornerY + 150 + (j * 15));
            j++;
        }
        if (currentPizza.isPepperoni())
        {
            graphics2D.setFont(new Font("Courier New", Font.BOLD,10));
            int actualWidth = graphics2D.getFontMetrics().stringWidth("Pepperoni");
            graphics2D.drawString("Pepperoni", displayTopCornerX + 420 - actualWidth, displayTopCornerY + 150 + (j * 15));
            j++;
        }
        if (currentPizza.isPineapple())
        {
            graphics2D.setFont(new Font("Courier New", Font.BOLD,10));
            int actualWidth = graphics2D.getFontMetrics().stringWidth("Pineapple");
            graphics2D.drawString("Pineapple", displayTopCornerX + 420 - actualWidth, displayTopCornerY + 150 + (j * 15));
            j++;
        }
        if (currentPizza.isMushrooms())
        {
            graphics2D.setFont(new Font("Courier New", Font.BOLD,10));
            int actualWidth = graphics2D.getFontMetrics().stringWidth("Mushrooms");
            graphics2D.drawString("Mushrooms", displayTopCornerX + 420 - actualWidth, displayTopCornerY + 150 + (j * 15));
            j++;
        }
        if (currentPizza.isJalapenos())
        {
            graphics2D.setFont(new Font("Courier New", Font.BOLD,10));
            int actualWidth = graphics2D.getFontMetrics().stringWidth("Jalapenos");
            graphics2D.drawString("Jalapenos", displayTopCornerX + 420 - actualWidth, displayTopCornerY + 150 + (j * 15));
        }

        // Player Info (Points + Pizzas Made)
        graphics2D.setPaint(new Color(241,243,244));
        graphics2D.fillRoundRect(displayTopCornerX + 260,displayTopCornerY + 20,170,100,30,15);
        graphics2D.setPaint(new Color(64,65,64));
        graphics2D.setFont(new Font("Courier New", Font.BOLD,14));
        graphics2D.drawString("POINTS",displayTopCornerX + 270,displayTopCornerY + 40);
        int actualWidth = graphics2D.getFontMetrics().stringWidth(String.valueOf(playerPoints));
        graphics2D.drawString(String.valueOf(playerPoints),displayTopCornerX + 420 - actualWidth,displayTopCornerY + 40);
        graphics2D.drawString("PIZZAS MADE",displayTopCornerX + 270,displayTopCornerY + 60);
        actualWidth = graphics2D.getFontMetrics().stringWidth(String.valueOf(pizzasMade));
        graphics2D.drawString(String.valueOf(pizzasMade),displayTopCornerX + 420 - actualWidth,displayTopCornerY + 60);

        // Lives Left
        graphics2D.setPaint(new Color(196,0,54));
        graphics2D.setStroke(new BasicStroke(3));
        for (int i = 0; i < 3; i++)
        {
            Path2D heartPath = drawHeartPath(displayTopCornerX + 280 + (i * 50),displayTopCornerY + 80,30,30);
            graphics2D.draw(heartPath);
        }
        for (int i = 0; i < livesLeft; i++)
        {
            Path2D heartPath = drawHeartPath(displayTopCornerX + 280 + (i * 50),displayTopCornerY + 80,30,30);
            graphics2D.fill(heartPath);
        }

        // Game Over Screen
        if (livesLeft <= 0)
        {
            graphics2D.setPaint(new Color(45,41,45));
            graphics2D.fillRoundRect(275,125,700,500,50,50);

            graphics2D.setPaint(new Color(196,0,54));
            graphics2D.setFont(new Font("Courier", Font.BOLD, 75));
            graphics2D.drawString("GAME OVER", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("GAME OVER") / 2), 275);

            // Game Over Button
            graphics2D.setPaint(new Color(190,190,190));
            graphics2D.fillRoundRect(475,400,300,125,50,50);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.drawRoundRect(475,400,300,125,50,50);
            graphics2D.setPaint(new Color(45,41,45));
            graphics2D.setFont(new Font("Courier", Font.BOLD, 32));
            graphics2D.drawString("Main", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("Main") / 2), 450);
            graphics2D.drawString("Menu", window.getWidth() / 2 - (graphics2D.getFontMetrics().stringWidth("Main") / 2), 500);
        }
    }

    public void updateScoreBoard(Pizza inputPizza)
    {
        if (inputPizza.comparePizza(currentPizza))
        {
            pizzasMade++;
            playerPoints += 10 * currentPizza.getNumIngredients();
        }
        else
        {
            livesLeft--;
        }
    }

    public void generateRandomPizzaRecipe()
    {
        int randomInt = 1 + (int)(Math.random() * 5);
        if (randomInt == 1)
        {
            currentPizza = cheesePizza;
        }
        else if (randomInt == 2)
        {
            currentPizza = pepperoniPizza;
        }
        else if (randomInt == 3)
        {
            currentPizza = allInPizza;
        }
        else if (randomInt == 4)
        {
            currentPizza = dryPizza;
        }
        else if (randomInt == 5)
        {
            currentPizza = veganPizza;
        }
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public void setPizzasMade(int pizzasMade) {
        this.pizzasMade = pizzasMade;
    }

    // Draw a heart
    private Path2D drawHeartPath(float x, float y, float width, float height) {
        float beX = x + width / 2;  // bottom endpoint X
        float beY = y + height;     // bottom endpoint Y

        float c1DX = width  * 0.968f;  // delta X of control point 1
        float c1DY = height * 0.672f;  // delta Y of control point 1
        float c2DX = width  * 0.281f;  // delta X of control point 2
        float c2DY = height * 1.295f;  // delta Y of control point 2
        float teDY = height * 0.850f;  // delta Y of top endpoint

        Path2D.Float heartPath = new Path2D.Float();
        heartPath.moveTo(beX, beY);       // bottom endpoint
        // left side of heart
        heartPath.curveTo(
                beX - c1DX, beY - c1DY,   // control point 1
                beX - c2DX, beY - c2DY,   // control point 2
                beX       , beY - teDY);  // top endpoint
        // right side of heart
        heartPath.curveTo(
                beX + c2DX, beY - c2DY,   // control point 2
                beX + c1DX, beY - c1DY,   // control point 1
                beX       , beY);         // bottom endpoint
        return heartPath;
    }
}
