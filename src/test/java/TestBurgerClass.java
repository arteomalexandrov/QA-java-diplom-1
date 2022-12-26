import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;


public class TestBurgerClass {
    @Mock
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Database database = new Database();
    List<Ingredient> ingredients = database.availableIngredients();
    List<Bun> buns = database.availableBuns();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void SetBunTest() {
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        Assert.assertEquals("black bun", burger.bun.name);

    }

    @Test
    public void AddIngredientCallTest() {
        burger.addIngredient(ingredients.get(0));
        Mockito.verify(burger).addIngredient(any());
    }

    @Test
    public void RemoveIngredientCallTest() {
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);
    }

    @Test
    public void RemoveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(0));
        Assert.assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }


    @Test
    public void getPriceBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(0f);
        Assert.assertEquals(200f, burger.getPrice(), 0);

    }

    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(0, 2);
        Mockito.verify(burger, Mockito.atLeastOnce()).moveIngredient(0, 2);
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(3));
        burger.moveIngredient(0, 2);
        Assert.assertEquals(ingredients.get(0), burger.ingredients.get(2));
    }

    @Test
    public void getReceiptCallTest() {
        burger.getReceipt();
        Mockito.verify(burger).getReceipt();

    }

    @Test
    public void getReceiptNullTest() {
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        Assert.assertNotNull(burger.getReceipt());
        burger.addIngredient(ingredients.get(0));
        Assert.assertNotNull(burger.getReceipt());
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        Assert.assertNotNull(burger.getReceipt());
        burger.addIngredient(ingredients.get(0));
        Assert.assertTrue(burger.getReceipt().contains("hot sauce"));
    }
}
