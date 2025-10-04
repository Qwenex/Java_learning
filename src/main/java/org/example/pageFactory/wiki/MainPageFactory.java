package org.example.pageFactory.wiki;

import org.example.pageObject.wiki.PersonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageFactory {

    private final WebDriver webDriver;

    private final static String URL = "https://ru.wikipedia.org/wiki/";

    @FindBy(id = "searchInput")
    private WebElement searchInputLabel;

    public MainPageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public MainPageFactory openPage() {
        webDriver.get(URL);
        return this;
    }

    public void closePage() {
        webDriver.quit();
    }

    public MainPageFactory searchInputSendKeys(String value) {
        searchInputLabel.sendKeys(value);
        return this;
    }

    public PersonPage searchInputSubmit() {
        searchInputLabel.submit();
        return new PersonPage(webDriver);
    }
}