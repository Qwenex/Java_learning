package org.example.cucumber.steps;

import io.cucumber.java.ru.*;
import org.example.page.wiki.MainPage;
import org.example.page.wiki.PersonPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WikipediaStepDefinitions {

    private MainPage mainPage;
    private PersonPage personPage;

    @Допустим("я открываю браузер Chrome")
    public void openChromeBrowser() {
        WebDriver driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        personPage = new PersonPage(driver);
    }

    @Допустим("перехожу на главную страницу Википедии")
    public void openPage() {
        mainPage.openPage();
    }

    @Допустим("я ввожу в поиск имя человека {string}")
    public void setName(String name) {
        mainPage.searchInputSendKeys(name);
    }

    @И("нажимаю Enter")
    public void pressEnter() {
        mainPage.searchInputSubmit();
    }

    @Тогда("дата рождения должна быть {string}")
    public void getBirthDate(String expectedDate ) {
        Assert.assertEquals( personPage.getBirthDate(), expectedDate);
    }

    @Тогда("дата смерти должна быть {string}")
    public void getDeathDate(String expectedDate) {
        try {
            Assert.assertEquals(personPage.getDeathDate(), expectedDate);
        } catch (NoSuchElementException ignored) {
        }
    }

    @Затем("закрываем браузер")
    public void shutDown() {
        mainPage.shutDown();
    }
}
