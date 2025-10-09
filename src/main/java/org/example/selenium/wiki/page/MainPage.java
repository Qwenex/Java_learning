package org.example.selenium.wiki.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final WebDriver webDriver;

    private final static String URL = "https://ru.wikipedia.org/wiki/";

    @FindBy(id = "searchInput")
    private WebElement searchInputLabel;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public MainPage openPage() {
        webDriver.get(URL);
        return this;
    }

    public void closePage() {
        webDriver.quit();
    }

    public MainPage searchInputSendKeys(String value) {
        searchInputLabel.sendKeys(value);
        return this;
    }

    public PersonPage searchInputSubmit() {
        searchInputLabel.submit();
        return new PersonPage(webDriver);
    }
}
