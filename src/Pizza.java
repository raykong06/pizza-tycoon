import java.util.ArrayList;

public class Pizza {
    private boolean tomatoSauce;
    private boolean cheese;
    private boolean pepperoni;
    private boolean pineapple;
    private boolean mushrooms;
    private boolean greenPepper;
    private ArrayList<Boolean> ingredientList;

    public Pizza()
    {
        this(false,false,false,false,false,false);
    }

    public Pizza (boolean tomatoSauce, boolean cheese, boolean pepperoni, boolean pineapple, boolean mushrooms, boolean greenPepper)
    {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.pineapple = pineapple;
        this.mushrooms = mushrooms;
        this.greenPepper = greenPepper;

        ingredientList = new ArrayList<Boolean>();
        ingredientList.add(tomatoSauce);
        ingredientList.add(cheese);
        ingredientList.add(pepperoni);
        ingredientList.add(pineapple);
        ingredientList.add(mushrooms);
        ingredientList.add(greenPepper);
    }

    public ArrayList<Boolean> getIngredientList()
    {
        return ingredientList;
    }

    // compares the ingredients of the two pizzas to see if they are equal
    public boolean comparePizza(Pizza pizzaRecipe, Pizza otherPizza)
    {
        boolean isEqual = true;
        for (int i = 0; i < pizzaRecipe.getIngredientList().size(); i++)
        {
            if (pizzaRecipe.getIngredientList().get(i) != otherPizza.getIngredientList().get(i))
            {
                isEqual = false;
            }
        }

        return isEqual;
    }

    public boolean isTomatoSauce() {
        return tomatoSauce;
    }

    public void setTomatoSauce(boolean tomatoSauce) {
        this.tomatoSauce = tomatoSauce;
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public boolean isPineapple() {
        return pineapple;
    }

    public void setPineapple(boolean pineapple) {
        this.pineapple = pineapple;
    }

    public boolean isMushrooms() {
        return mushrooms;
    }

    public void setMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
    }

    public boolean isGreenPepper() {
        return greenPepper;
    }

    public void setGreenPepper(boolean greenPepper) {
        this.greenPepper = greenPepper;
    }

}
