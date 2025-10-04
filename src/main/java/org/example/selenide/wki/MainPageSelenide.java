package org.example.selenide.wki;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageSelenide {

    private final SelenideElement searchInputField = $(By.id("searchInput"));
    private final static String URL = "https://ru.wikipedia.org/wiki/";

    public MainPageSelenide openPage() {
        open(URL);
        return this;
    }

    public MainPageSelenide searchInputSendKeys(String value) {
        searchInputField.setValue(value);
        return this;
    }

    public PersonPageSelenide searchInputSubmit() {
        searchInputField.pressEnter();
        return Selenide.page(PersonPageSelenide.class);
    }
}
