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

public class ProgramVersionTest {

    @DataProvider(name = "ProgramVersionDataProvider")
    public static Object[][] ProgramVersionDataProvider() {
        return new Object[][]{
                {"programName", "1.0.0"},
                {"programAnotherName", "2.5.6"},
                {"pluginName1", "0.5.1.3"},
                {"modification138", "356.2"}
        };
    }

    @Epic(value = "Программы и плагины")
    @Feature(value = "Список программ и плагинов")
    @Story(value = "Проверка версий программ")
    @Step(value = "Проверка версии")
    @Severity(SeverityLevel.NORMAL)
    @Description(value = "Проверка версии программы из файла \"properties\"")
    @Test(description = "Проверка версии программы", dataProvider = "ProgramVersionDataProvider")
    public void ProgramVersionFromProperty(String login, String password) throws IOException, URISyntaxException {
        Properties properties = new Properties();
        URL resource = getClass().getClassLoader().getResource("programVersion/version.properties");
        Assert.assertNotNull(resource, "файл .property не найден");
        properties.load(Files.newInputStream(Paths.get(resource.toURI())));
        Assert.assertEquals(properties.getProperty(login), password, "Версия программы отличается от ожидаемой");
    }
}
