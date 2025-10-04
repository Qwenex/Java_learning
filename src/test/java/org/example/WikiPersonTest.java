package org.example;
import org.example.pageFactory.wiki.MainPageFactory;
import org.example.pageObject.wiki.MainPage;
import org.example.pageObject.wiki.PersonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Разные способы написания теста: {сравнения периода жизни известных личностей на Wikipedia}
 * Одинаковые тесты оставлены для няглодности работоспособности различных методов написания тестов.
 * 1.Casual Test -> 2.Page Object Model -> 3.POM + Fluent -> 4.PageFactory -> 5.Selenide(отдельный класс)
 */
public class WikiPersonTest {

    WebDriver driver = new ChromeDriver();
    MainPage mainPage = new MainPage(driver);
    MainPageFactory mainPageFactory = new MainPageFactory(driver);

    @BeforeMethod
    public void openPage() {
        mainPage.openPage();
    }

    @AfterClass
    public void closePage() {
        mainPage.closePage();
    }

    @Deprecated // Для v1-2
    @DataProvider(name = "personNameAndYearsOfLife")
    public static Object[][] personYearsDataProvider() {
        return new Object[][]{
                {"Жак Фреско", "13 марта 1916", "18 мая 2017"},
                {"Никола Тесла", "10 июля 1856", "7 января 1943"},
                {"Вин Дизель", "18 июля 1967", null},
                {"Сергей Бодров мл.","27 декабря 1971","20 сентября 2002"}
        };
    }

    @DataProvider(name = "personNameAndBirthDate")
    public static Object[][] personBirthDataProvider() {
        return new Object[][]{
                {"Жак Фреско", "13 марта 1916"},
                {"Никола Тесла", "10 июля 1856"},
                {"Вин Дизель", "18 июля 1967"},
                {"Сергей Бодров мл.", "27 декабря 1971"}
        };
    }

    @DataProvider(name = "personNameAndDeathDate")
    public static Object[][] personDeathDataProvider() {
        return new Object[][]{
                {"Жак Фреско", "18 мая 2017"},
                {"Никола Тесла", "7 января 1943"},
                {"Вин Дизель", null},
                {"Сергей Бодров мл.", "20 сентября 2002"}
        };
    }

    // v1 Примитивный тест без паттернов (From task33)
    @Test(description = "Соотвтетствие периода жизни", dataProvider = "personNameAndYearsOfLife")
    public void personTest1(String name, String dateOfBirth, String dateOfDeath) {
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys(name);
        searchInput.submit();

        String birthDateActual = null;
        String deathDateActual = null;
        try {
            birthDateActual = driver.findElement(By.xpath(
                    "//*[text()='Дата\u00A0рождения']/..//span[@class='nowrap']")).getText();
            deathDateActual = driver.findElement(By.xpath(
                    "//*[text()='Дата\u00A0смерти']/..//span[@class='nowrap']")).getText();
        } catch (NoSuchElementException ignored) {
        }
        Assert.assertEquals(birthDateActual, dateOfBirth, "Дни рождения не совпадают: " + name);
        Assert.assertEquals(deathDateActual, dateOfDeath, "Дни смерти не совпадают: " + name);
    }

    // v2 Тест с использованием Page Object Model (POM)
    @Test(description = "Соотвтетствие периода жизни v2", dataProvider = "personNameAndYearsOfLife")
    public void personTest2(String name, String dateOfBirth, String dateOfDeath) {
        mainPage.searchInputSendKeys(name);
        mainPage.searchInputSubmit();
        PersonPage personPage = new PersonPage(driver);
        try {
            Assert.assertEquals(personPage.getBirthDate(), dateOfBirth, "Дни рождения не совпадают: " + name);
            Assert.assertEquals(personPage.getDeathDate(), dateOfDeath, "Дни смерти не совпадают: " + name);
        } catch (NoSuchElementException ignored) {
        }
    }

    // v3 Отдельные тесты POM + Fluent
    @Test(description = "Соотвтетствие даты рождения", dataProvider = "personNameAndBirthDate")
    public void personTest3(String name, String dateOfBirth) {
        String birthDateActual = mainPage
                .searchInputSendKeys(name)
                .searchInputSubmit()
                .getBirthDate();
        Assert.assertEquals(birthDateActual, dateOfBirth, "Дни рождения не совпадают: " + name);
    }

    @Test(description = "Соотвтетствие даты смерти", dataProvider = "personNameAndDeathDate")
    public void personTest4(String name, String dateOfDeath) {
        try {
            String deathDateActual = mainPage
                    .searchInputSendKeys(name)
                    .searchInputSubmit()
                    .getDeathDate();
            Assert.assertEquals(deathDateActual, dateOfDeath, "Дни смерти не совпадают: " + name);
        } catch (NoSuchElementException e) {
            System.out.printf("Для личности {%s} не найдено поле \"Дата смерти\"", name);
        }
    }

    // v4 PageFactory (изменений для тестов нет)
    @Test(description = "Соотвтетствие даты рождения", dataProvider = "personNameAndBirthDate")
    public void personTest5(String name, String dateOfBirth) {
        String birthDateActual = mainPageFactory
                .searchInputSendKeys(name)
                .searchInputSubmit()
                .getBirthDate();
        Assert.assertEquals(birthDateActual, dateOfBirth, "Дни рождения не совпадают: " + name);
    }

    @Test(description = "Соотвтетствие даты смерти", dataProvider = "personNameAndDeathDate")
    public void personTest6(String name, String dateOfDeath) {
        try {
            String deathDateActual = mainPageFactory
                    .searchInputSendKeys(name)
                    .searchInputSubmit()
                    .getDeathDate();
            Assert.assertEquals(deathDateActual, dateOfDeath, "Дни смерти не совпадают: " + name);
        } catch (NoSuchElementException e) {
            System.out.printf("Для личности {%s} не найдено поле \"Дата смерти\"", name);
        }
    }
}