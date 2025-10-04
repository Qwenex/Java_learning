package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WikiPersonTest {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void openWebPage() {
        driver.get("https://ru.wikipedia.org/wiki/");
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

    @DataProvider(name = "personNameAndYearsOfLife")
    public static Object[][] personDataProvider() {
        return new Object[][]{
                {"Жак Фреско", "13 марта 1916", "18 мая 2017"},
                {"Никола Тесла", "10 июля 1856", "7 января 1943"},
                {"Вин Дизель", "18 июля 1967", null}
        };
    }

    @Test(description = "Соотвтетствие имени и периода жизни",
            dataProvider = "personNameAndYearsOfLife")
    public void personTest(String name, String dateOfBirth, String dateOfDeath) {
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys(name);
        searchInput.submit();

        String deathDateActual = null;
        String birthDateActual = null;
        try {
            birthDateActual = driver.findElement(By.xpath(
                    "//*[text()='Дата\u00A0рождения']/..//span[@class='nowrap']")).getText();
            deathDateActual = driver.findElement(By.xpath(
                    "//*[text()='Дата\u00A0смерти']/..//span[@class='nowrap']")).getText();
        } catch (NoSuchElementException e) {
        }
        Assert.assertEquals(birthDateActual, dateOfBirth, "Дни рождения не совпадают");
        Assert.assertEquals(deathDateActual, dateOfDeath, "Дни смерти не совпадают");
    }
}
