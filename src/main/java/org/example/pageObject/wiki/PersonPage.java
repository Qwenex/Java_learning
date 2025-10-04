package org.example.pageObject.wiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonPage {

    private final WebDriver webDriver;

    private final By birthDateLabelSelector = By.xpath(
            "//*[text()='Дата\u00A0рождения']/..//span[@class='nowrap']");
    private final By deathDateLabelSelector = By.xpath(
            "//*[text()='Дата\u00A0смерти']/..//span[@class='nowrap']");

    public PersonPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getBirthDate() {
        WebElement element = webDriver.findElement(birthDateLabelSelector);
        return element.getText();
    }

    public String getDeathDate() {
        WebElement element = webDriver.findElement(deathDateLabelSelector);
        return element.getText();
    }
}