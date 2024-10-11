package org.example;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class AuthorizationTest {

    @DataProvider(name = "authorizationDataProvider")
    public static Object[][] authorizationDataProvider() {
        return new Object[][]{
                {"admin", "adminPassword"},
                {"user", "userPassword"},
                {"user2", "user2Password"},
        };
    }

    @Epic(value = "Авторизация пользователя")
    @Feature(value = "Проверка логина и пароля пользователя на валидность")
    @Story(value = "Проверка логина и пароля из файла \"xml\"")
    @Step(value = "Проверка логина и пароля из файла \"xml\"")
    @Severity(SeverityLevel.CRITICAL)
    @Description(value = "Проверка на считывание из файла \"xml\" логина и пароля")
    @Test(description = "Проверка логина и пароля", dataProvider = "authorizationDataProvider")
    public void authorizationFromXml(String login, String password) throws IOException, URISyntaxException {
        Properties properties = new Properties();
        URL resource = getClass().getClassLoader().getResource("authorization/authorization.xml");
        Assert.assertNotNull(resource, "Файл .xml не найден");
        properties.loadFromXML(Files.newInputStream(Paths.get(resource.toURI())));
        Assert.assertEquals(properties.getProperty(login), password, "Пароль не подходит к этому логину");
    }

    @Epic(value = "Авторизация пользователя")
    @Feature(value = "Проверка логина и пароля пользователя на валидность")
    @Story(value = "Проверка логина и пароля из файла \"property\"")
    @Step(value = "Проверка логина и пароля из файла \"property\"")
    @Severity(SeverityLevel.CRITICAL)
    @Description(value = "Проверка на считывание из файла \"property\" логина и пароля")
    @Test(description = "Проверка логина и пароля", dataProvider = "authorizationDataProvider")
    public void authorizationFromProperty(String login, String password) throws IOException, URISyntaxException {
        Properties properties = new Properties();
        URL resource = getClass().getClassLoader().getResource("authorization/authorization2.properties");
        Assert.assertNotNull(resource, "файл .property не найден");
        properties.load(Files.newInputStream(Paths.get(resource.toURI())));
        Assert.assertEquals(properties.getProperty(login), password, "Пароль не подходит к этому логину");
    }
}
