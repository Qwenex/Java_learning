package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfig {

    /**
     * Загрузка данных из файла .property
     * @param propertyFile Считываемый файл .property
     * @param propertyParam Считываемый параметр из файла (ключ)
     * @return Значение заданного параметра
     */
    public static String getProperty(String propertyFile, String propertyParam) {
        Properties urlProperties = new Properties();
        try (InputStream input = PropertyConfig.class.getClassLoader().getResourceAsStream(propertyFile)) {
            urlProperties.load(input);
            return urlProperties.getProperty(propertyParam);
        } catch (IOException e) {
            throw new RuntimeException("Файл userEndpoints не найден в resources!");
        }
    }

}
