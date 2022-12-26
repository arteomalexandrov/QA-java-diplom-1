import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TestParameterizedPrice {

    private final String bunName;
    private final float bunCost;
    private final String sauceName;
    private final float sauceCost;
    private final String meatName;
    private final float meatCost;
    private final float expectedCost;

    public TestParameterizedPrice(String bunName, float bunCost, String sauceName, float sauceCost, String meatName, float meatCost, float expectedCost) {
        this.bunName = bunName;
        this.bunCost = bunCost;
        this.sauceName = sauceName;
        this.sauceCost = sauceCost;
        this.meatName = meatName;
        this.meatCost = meatCost;
        this.expectedCost = expectedCost;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"white bun", 50f, "hot sauce", 100f, "Meat", 100f, 300f},
                {"black bun", 80f, "chilli sauce", 150f, "Chicken", 50f, 360f},
                {"red bun", 95f, "sour cream", 150f, "Fish", 50f, 390f},
        };
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();

        burger.setBuns(new Bun(bunName, bunCost));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, sauceName, sauceCost));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, meatName, meatCost));
        Assert.assertEquals(expectedCost, burger.getPrice(), 0);

    }
}