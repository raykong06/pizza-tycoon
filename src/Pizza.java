import java.util.ArrayList;

public class Pizza {
    private boolean tomatoSauce;
    private boolean cheese;
    private boolean pepperoni;
    private boolean pineapple;
    private boolean mushrooms;
    private boolean greenPepper;
    private ArrayList<Boolean> ingredientList;

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

}
