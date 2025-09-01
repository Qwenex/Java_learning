package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyParser {

    private static Object convertValue(String value, Class<?> type) {
        if (type == Integer.class) return Integer.parseInt(value);
        if (type == Double.class) return Double.parseDouble(value);
        return value;
    }

    public static Object parse(String json, Class<?> clazz)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor<?> constructor = clazz.getConstructor();
        Object obj =  constructor.newInstance();

        String cleanJson = json.replaceAll("[\\s{}]", "");
        String[] splitJson = cleanJson.split(",");

        for (String keyValue : splitJson) {
            String[] splitKeyValue = keyValue.split(":");

            String key = splitKeyValue[0];
            String value = splitKeyValue[1];
            String cleanKey = key.replaceAll("[\"]", "");
            String setKey = "set" + cleanKey.substring(0, 1).toUpperCase() + cleanKey.substring(1);

            for (Method method : clazz.getMethods()) {
                if (method.getName().equals(setKey)) {
                    Class<?> paramType = method.getParameterTypes()[0];
                    Object convertedValue = convertValue(value, paramType);
                    method.invoke(obj, convertedValue);
                    break;
                }
            }
        }
        return obj;
    }
}


