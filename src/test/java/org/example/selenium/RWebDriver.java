package org.example.selenium;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RWebDriver {

    public RemoteWebDriver driver;

    public RemoteWebDriver setUpDriver() throws MalformedURLException {
        String remoteURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        return driver = new RemoteWebDriver(new URL(remoteURL), capabilities);
    }

    public void tearDownDriver (RemoteWebDriver driver) {
        driver.quit();
    }
}
