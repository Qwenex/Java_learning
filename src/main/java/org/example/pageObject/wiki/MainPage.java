package org.example.pageObject.wiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver webDriver;

    private final static String URL = "https://ru.wikipedia.org/wiki/";
    private final By searchInputSelector = By.id("searchInput");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage openPage() {
        webDriver.get(URL);
        return this;
    }

    public void closePage() {
        webDriver.quit();
    }

    public MainPage searchInputSendKeys(String value) {
        WebElement searchInput = webDriver.findElement(searchInputSelector);
        searchInput.sendKeys(value);
        return this;
    }

    public PersonPage searchInputSubmit() {
        WebElement searchInput = webDriver.findElement(searchInputSelector);
        searchInput.submit();
        return new PersonPage(webDriver);
    }
}