import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class GameArea extends JPanel{

    private double xCoord;
    private double yCoord;

    private double velX;
    private double velY;
    private double jumpVel;
    private double gravity;
    private int speed;
    private ImageIcon cheese;
    private ImageIcon pepperoniShelf;
    private ImageIcon pepperoniPlace;
    private ImageIcon pineappleShelf;
    private ImageIcon pineapplePlace;
    private ImageIcon mushrooms;
    private ImageIcon jalapenos;
    private ImageIcon gameAreaBackground;
    private int spriteCounter;
    private int spriteNum;
    private PlayerScoreBoard playerScoreBoard;
    private Window window;
    private int pizzaX;
    private int pizzaY;
    private Pizza currentPizza;
    private boolean holdingTomatoSauce;
    private boolean holdingCheese;
    private boolean holdingPepperoni;
    private boolean holdingPineapple;
    private boolean holdingMushrooms;
    private boolean holdingJalapenos;

    public GameArea(Window window)
    {
        this.window = window;
        xCoord = 1000 / 2.0;
        yCoord = 750 / 2.0 - 50;
        playerScoreBoard = new PlayerScoreBoard(window);

        gravity = 4;
        jumpVel = 10;
        speed = 4;

        cheese = new ImageIcon("img/cheese.png");
        pepperoniShelf = new ImageIcon("img/pepperoni_shelf.png");
        pepperoniPlace = new ImageIcon("img/pepperoni_place.png");
        pineappleShelf = new ImageIcon("img/pineapple_shelf.png");
        pineapplePlace = new ImageIcon("img/pineapple_place.png");
        mushrooms = new ImageIcon("img/mushrooms.png");
        jalapenos = new ImageIcon("img/jalapenos.png");
        gameAreaBackground = new ImageIcon("img/game_area_background.png");

        spriteCounter = 0;
        spriteNum = 0;

        pizzaX = -250;
        pizzaY = 525;

        currentPizza = new Pizza();

        holdingTomatoSauce = false;
    }

    public void tick()
    {
        xCoord += velX;

        if (velY < gravity)
        {
            velY += 0.45;
        }

        if (yCoord + velY < window.getHeight() / 2.0)
        {
            yCoord += velY;
        }
        else
        {
            velY = 0;
        }
    }

    public void paintComponent(Graphics graphics)
    {
        //display = imgArr.get(spriteNum);
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        gameAreaBackground.paintIcon(this, graphics2D, 0, 0);
        //display.paintIcon(this, graphics, (int)xCoord, (int)yCoord);

        spriteCounter++;
        int speed = 1;
        if (playerScoreBoard.getLivesLeft() <= 0)
        {
            speed = 0;
        }

        if (spriteCounter * speed - 250 > 1306)
        {
            spriteCounter = 0;
            playerScoreBoard.updateScoreBoard(currentPizza);
            playerScoreBoard.generateRandomPizzaRecipe();
            currentPizza.setTomatoSauce(false);
            currentPizza.setCheese(false);
            currentPizza.setPepperoni(false);
            currentPizza.setPineapple(false);
            currentPizza.setMushrooms(false);
            currentPizza.setJalapenos(false);
        }

        // Conveyor Belt
        graphics2D.setPaint(new Color(198,198,198));
        graphics2D.fillRect(-100,500,1400,300);
        graphics2D.setPaint(new Color(156,156,156));
        int conveyorLineX = -1450 + (spriteCounter * speed);
        int conveyorLineGap = 130;
        graphics2D.setStroke(new BasicStroke(3));
            // bottom line
        graphics2D.drawLine(0, 700, 1250, 700);
            // Conveyor Belt Lines
        for (int i = 0; i < 25; i++)
        {
            graphics2D.drawLine(conveyorLineX + (conveyorLineGap * i), 500, conveyorLineX - 25 + (conveyorLineGap * i), 700);
        }

        // Pizza
        graphics2D.setPaint(new Color(244,203,146));
        // Change Pizza Depending on Ingredients
        if (currentPizza.isTomatoSauce())
        {
            graphics2D.setPaint(new Color(255,77,0));
        }
        graphics2D.fill(new Ellipse2D.Double(-250 + (spriteCounter * speed), 525, 200, 150));
        if (currentPizza.isCheese())
        {
            for (int i = 0; i < 3; i++)
            {
                cheese.paintIcon(this,graphics2D,-250 + (spriteCounter * speed),530 + (i * 27));
            }
        }
        if (currentPizza.isPepperoni())
        {
            pepperoniPlace.paintIcon(this,graphics2D,-215 + (spriteCounter * speed),530);
        }
        if (currentPizza.isPineapple())
        {
            pineapplePlace.paintIcon(this,graphics2D,-230 + (spriteCounter * speed),535);
            pineapplePlace.paintIcon(this,graphics2D,-150 + (spriteCounter * speed),555);
            pineapplePlace.paintIcon(this,graphics2D,-205 + (spriteCounter * speed),595);
        }
        if (currentPizza.isMushrooms())
        {
            mushrooms.paintIcon(this,graphics2D,-230 + (spriteCounter * speed),550);
            mushrooms.paintIcon(this,graphics2D,-177 + (spriteCounter * speed),540);
            mushrooms.paintIcon(this,graphics2D,-140 + (spriteCounter * speed),570);
            mushrooms.paintIcon(this,graphics2D,-200 + (spriteCounter * speed),570);
        }
        if (currentPizza.isJalapenos())
        {
            jalapenos.paintIcon(this,graphics2D,-220 + (spriteCounter * speed),545);
            jalapenos.paintIcon(this,graphics2D,-215 + (spriteCounter * speed) + 75,540 + 30);
            jalapenos.paintIcon(this,graphics2D,-210 + (spriteCounter * speed) + 20,540 + 55);
        }

        graphics2D.setStroke(new BasicStroke(10));
        graphics2D.setPaint(new Color(196,134,1));
        graphics2D.draw(new Ellipse2D.Double(-250 + (spriteCounter * speed), 525, 200, 150));
        pizzaX = -250 + (spriteCounter * speed) + 100;
        pizzaY = 525 + 75;

        // Ingredient Shelf
        graphics2D.setPaint(new Color(102,102,102));
        graphics2D.fillRect(-100,350,1400,140);
        graphics2D.setPaint(new Color(103,51,1));
        graphics2D.fillRect(-100,460,1400,40);
        graphics2D.setPaint(new Color(0,0,0));
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.drawLine(0, 460, 1250, 460);
        graphics2D.drawLine(0, 350, 1250, 350);
        graphics2D.drawLine(0, 500, 1250, 500);

        // Tomato Sauce Shelf
        graphics2D.setPaint(new Color(51,51,51));
        graphics2D.fillRect(60,360,200,75);
        graphics2D.setPaint(new Color(0,0,0));
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(60,360,200,75);
        graphics2D.setPaint(new Color(255,77,0));
        graphics2D.fillRoundRect(135,280,50,100,5,5);
        graphics2D.fillPolygon(new int[] {145,175,160},new int[] {380,380,420},3);
        graphics2D.setPaint(new Color(0,0,0));
        graphics2D.drawRoundRect(135,280,50,100,5,5);
        graphics2D.setStroke(new BasicStroke(3,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL));
        graphics2D.drawPolygon(new int[] {145,175,160},new int[] {380,380,420},3);

        // Cheese Shelf
        graphics2D.setPaint(new Color(51,51,51));
        graphics2D.fillRect(300,360,200,75);
        graphics2D.setPaint(new Color(0,0,0));
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(300,360,200,75);
        cheese.paintIcon(this,graphics2D,285 + 30,350);
        cheese.paintIcon(this,graphics2D,285,360);
        cheese.paintIcon(this,graphics2D,285 + 15,340);

        // Pepperoni Shelf
        graphics2D.setPaint(new Color(51,51,51));
        graphics2D.fillRect(560,360,200,75);
        graphics2D.setPaint(new Color(0,0,0));
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(560,360,200,75);
        pepperoniShelf.paintIcon(this,graphics2D,570 + 30,330);
        pepperoniShelf.paintIcon(this,graphics2D, 570,330);
        pepperoniShelf.paintIcon(this,graphics2D,570 + 15,330);

        // Pineapple Shelf
        graphics2D.setPaint(new Color(51,51,51));
        graphics2D.fillRect(780,360,150,75);
        graphics2D.setPaint(new Color(0,0,0));
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(780,360,150,75);
        pineappleShelf.paintIcon(this,graphics2D,770,295);

        // Mushroom Shelf
        graphics2D.setPaint(new Color(51,51,51));
        graphics2D.fillRect(950,360,100,75);
        graphics2D.setPaint(new Color(0,0,0));
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(950,360,100,75);
        mushrooms.paintIcon(this,graphics2D,950,360);
        mushrooms.paintIcon(this,graphics2D,950 + 10,350);
        mushrooms.paintIcon(this,graphics2D,950 + 30,360);
        mushrooms.paintIcon(this,graphics2D,950 + 20,345);
        mushrooms.paintIcon(this,graphics2D,950 + 40,360);
        mushrooms.paintIcon(this,graphics2D,950 + 55,355);
        mushrooms.paintIcon(this,graphics2D,950 + 50,350);

        // Jalapenos Shelf
        graphics2D.setPaint(new Color(51,51,51));
        graphics2D.fillRect(1070,360,100,75);
        graphics2D.setPaint(new Color(0,0,0));
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(1070,360,100,75);
        jalapenos.paintIcon(this,graphics2D,1070,370);
        jalapenos.paintIcon(this,graphics2D,1100,360);

        // Dragging Tomato Sauce
        if (holdingTomatoSauce)
        {
            Point p = MouseInfo.getPointerInfo().getLocation();

            int mousePressX = p.x - 25 - window.getLocationOnScreen().x;
            int mousePressY = p.y - 125 - window.getLocationOnScreen().y;
            graphics2D.setPaint(new Color(255,77,0));
            graphics2D.fillRoundRect(mousePressX,mousePressY,50,100,5,5);
            graphics2D.fillPolygon(new int[] {mousePressX + 10,mousePressX + 40,mousePressX + 25},new int[] {mousePressY + 100,mousePressY + 100,mousePressY + 140},3);
            graphics2D.setPaint(new Color(0,0,0));
            graphics2D.drawRoundRect(mousePressX,mousePressY,50,100,5,5);
            graphics2D.setStroke(new BasicStroke(3,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL));
            graphics2D.drawPolygon(new int[] {mousePressX + 10,mousePressX + 40,mousePressX + 25},new int[] {mousePressY + 100,mousePressY + 100,mousePressY + 140},3);
        }

        // Dragging Cheese
        if (holdingCheese)
        {
            Point p = MouseInfo.getPointerInfo().getLocation();

            int mousePressX = p.x - 100 - window.getLocationOnScreen().x;
            int mousePressY = p.y - 40 - window.getLocationOnScreen().y;

            cheese.paintIcon(this,graphics2D,mousePressX,mousePressY);
        }

        // Dragging Pepperoni
        if (holdingPepperoni)
        {
            Point p = MouseInfo.getPointerInfo().getLocation();

            int mousePressX = p.x - 65 - window.getLocationOnScreen().x;
            int mousePressY = p.y - 67 - window.getLocationOnScreen().y;

            pepperoniPlace.paintIcon(this,graphics2D,mousePressX,mousePressY);
        }

        // Dragging Pineapple
        if (holdingPineapple)
        {
            Point p = MouseInfo.getPointerInfo().getLocation();

            int mousePressX = p.x - 38 - window.getLocationOnScreen().x;
            int mousePressY = p.y - 35 - window.getLocationOnScreen().y;

            pineapplePlace.paintIcon(this,graphics2D,mousePressX,mousePressY);
        }

        // Dragging Mushrooms
        if (holdingMushrooms)
        {
            Point p = MouseInfo.getPointerInfo().getLocation();

            int mousePressX = p.x - 47 - window.getLocationOnScreen().x;
            int mousePressY = p.y - 38 - window.getLocationOnScreen().y;

            mushrooms.paintIcon(this,graphics2D,mousePressX,mousePressY);
            mushrooms.paintIcon(this,graphics2D,mousePressX + 47,mousePressY);
        }

        // Dragging Jalapenos
        if (holdingJalapenos)
        {
            Point p = MouseInfo.getPointerInfo().getLocation();

            int mousePressX = p.x - 38 - window.getLocationOnScreen().x;
            int mousePressY = p.y - 33 - window.getLocationOnScreen().y;

            jalapenos.paintIcon(this,graphics2D,mousePressX,mousePressY);
        }

        playerScoreBoard.paintComponent(graphics);
    }

    public void reset()
    {
        currentPizza = new Pizza();
        playerScoreBoard.setLivesLeft(3);
        spriteCounter = 0;
        playerScoreBoard.setPlayerPoints(0);
        playerScoreBoard.setPizzasMade(0);
    }

    public int getPizzaX() {
        return pizzaX;
    }

    public int getPizzaY() {
        return pizzaY;
    }

    public Pizza getCurrentPizza() {
        return currentPizza;
    }

    public boolean isHoldingTomatoSauce() {
        return holdingTomatoSauce;
    }

    public void setHoldingTomatoSauce(boolean holdingTomatoSauce) {
        this.holdingTomatoSauce = holdingTomatoSauce;
    }

    public boolean isHoldingCheese() {
        return holdingCheese;
    }

    public void setHoldingCheese(boolean holdingCheese) {
        this.holdingCheese = holdingCheese;
    }

    public boolean isHoldingPepperoni() {
        return holdingPepperoni;
    }

    public void setHoldingPepperoni(boolean holdingPepperoni) {
        this.holdingPepperoni = holdingPepperoni;
    }

    public boolean isHoldingPineapple() {
        return holdingPineapple;
    }

    public void setHoldingPineapple(boolean holdingPineapple) {
        this.holdingPineapple = holdingPineapple;
    }

    public boolean isHoldingMushrooms() {
        return holdingMushrooms;
    }

    public void setHoldingMushrooms(boolean holdingMushrooms) {
        this.holdingMushrooms = holdingMushrooms;
    }

    public boolean isHoldingJalapenos() {
        return holdingJalapenos;
    }

    public void setHoldingJalapenos(boolean holdingJalapenos) {
        this.holdingJalapenos = holdingJalapenos;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public double getJumpVel() {
        return jumpVel;
    }

    public int getSpeed() {
        return speed;
    }

    public PlayerScoreBoard getPlayerScoreBoard()
    {
        return playerScoreBoard;
    }


}
