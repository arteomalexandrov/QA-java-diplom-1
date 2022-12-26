import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class TestBunClass {

    @Test
    public void TestBunCreate() {
        Bun bun = new Bun("Black bun", 100);
        Assert.assertEquals("Black bun", bun.name);
    }

    @Test
    public void TestBunPrice() {
        Bun bun = new Bun("Black bun", 100f);
        Assert.assertEquals(100f, bun.getPrice(), 0);
    }
}