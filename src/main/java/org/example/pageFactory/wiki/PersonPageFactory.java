package org.example.pageFactory.wiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonPageFactory {

    private final WebDriver webDriver;

    @FindBy(xpath = "//*[text()='Дата\u00A0рождения']/..//span[@class='nowrap']")
    private WebElement birthDateLabel;

    @FindBy(xpath = "//*[text()='Дата\u00A0смерти']/..//span[@class='nowrap']")
    private WebElement deathDateLabel;

    public PersonPageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getBirthDate() {
        return birthDateLabel.getText();
    }

    public String getDeathDate() {
        return deathDateLabel.getText();
    }
}