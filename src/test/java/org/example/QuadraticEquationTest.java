package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QuadraticEquationTest {

    @DataProvider(name = "rootDataProvider")
    public static Object[][] rootDataProvider() {
        return new Object[][]{
                {5, 7, 2, new Root(-10.0, -25.0)},
                {2, -11, 15, new Root(12.0, 10.0)},
                {1, -4, 4, new Root(2.0)},
                {4, 2, 2, new Root()}
        };
    }

    @Test(description = "Решение квадратного уравнения", dataProvider = "rootDataProvider")
    public void solveTwoRootTest(int a, int b, int c, Root root) {
        Root actualRoot = QuadraticEquation.solve(a, b, c);
        Assert.assertNotNull(actualRoot, "Решение уравнения не может быть \"null\"");
        Assert.assertEquals(actualRoot, root);
    }
}
