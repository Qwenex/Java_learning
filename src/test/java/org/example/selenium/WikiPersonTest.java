package org.example.selenium;

import org.example.selenium.wiki.page.MainPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class WikiPersonTest{

    RWebDriver rWebDriver = new RWebDriver();

    @DataProvider(name = "personNameAndBirthDate", parallel = true)
    public static Object[][] personBirthDataProvider() {
        return new Object[][]{
                {"Жак Фреско", "13 марта 1916"},
                {"Никола Тесла", "10 июля 1856"},
                {"Вин Дизель", "18 июля 1967"},
                {"Сергей Бодров мл.", "27 декабря 1971"}
        };
    }

    @DataProvider(name = "personNameAndDeathDate", parallel = true)
    public static Object[][] personDeathDataProvider() {
        return new Object[][]{
                {"Жак Фреско", "18 мая 2017"},
                {"Никола Тесла", "7 января 1943"},
                {"Вин Дизель", null},
                {"Сергей Бодров мл.", "20 сентября 2002"}
        };
    }

    @Test(description = "Соотвтетствие даты рождения", dataProvider = "personNameAndBirthDate")
    public void personTestBirth(String name, String dateOfBirth) throws MalformedURLException {
        RemoteWebDriver driver = rWebDriver.setUpDriver();
        MainPage mainPage = new MainPage(driver);
        String birthDateActual = mainPage
                .openPage()
                .searchInputSendKeys(name)
                .searchInputSubmit()
                .getBirthDate();
        Assert.assertEquals(birthDateActual, dateOfBirth, "Дни рождения не совпадают: " + name);
        rWebDriver.tearDownDriver(driver);
    }

    @Test(description = "Соотвтетствие даты смерти", dataProvider = "personNameAndDeathDate")
    public void personTestDeath(String name, String dateOfDeath) throws MalformedURLException {
        RemoteWebDriver driver = rWebDriver.setUpDriver();
        MainPage mainPage = new MainPage(driver);
        try {
            String deathDateActual = mainPage
                    .openPage()
                    .searchInputSendKeys(name)
                    .searchInputSubmit()
                    .getDeathDate();
            Assert.assertEquals(deathDateActual, dateOfDeath, "Дни смерти не совпадают: " + name);
        } catch (NoSuchElementException e) {
            System.out.printf("Для личности {%s} не найдено поле \"Дата смерти\"", name);
        }
        rWebDriver.tearDownDriver(driver);
    }
}
