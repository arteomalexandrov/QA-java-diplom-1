import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class TestIngredientClass {
    @Test
    public void TestIngredientCreate() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chilli pepper", 150f);
        Assert.assertEquals("chilli pepper", ingredient.name);
        Assert.assertEquals(150f, ingredient.price, 0);
    }
}