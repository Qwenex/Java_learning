package org.example;

import com.codeborne.selenide.ex.ElementNotFound;
import org.example.selenide.wki.MainPageSelenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WikiPersonSelenideTest {

    MainPageSelenide mainPageSelenide = new MainPageSelenide();

    @BeforeMethod
    public void openPage() {
        mainPageSelenide.openPage();
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

    // v5 Selenide
    @Test(description = "Соотвтетствие даты рождения", dataProvider = "personNameAndBirthDate")
    public void personTest7(String name, String dateOfBirth) {
        String birthDateActual = mainPageSelenide
                .searchInputSendKeys(name)
                .searchInputSubmit()
                .getBirthDate();
        Assert.assertEquals(birthDateActual, dateOfBirth, "Дни рождения не совпадают: " + name);
    }

    @Test(description = "Соотвтетствие даты смерти", dataProvider = "personNameAndDeathDate")
    public void personTest8(String name, String dateOfDeath) {
        try {
            String deathDateActual = mainPageSelenide
                    .searchInputSendKeys(name)
                    .searchInputSubmit()
                    .getDeathDate();
            Assert.assertEquals(deathDateActual, dateOfDeath, "Дни смерти не совпадают: " + name);
        } catch (ElementNotFound e) {
            System.out.printf("Для личности {%s} не найдено поле \"Дата смерти\"", name);
        }
    }
}
