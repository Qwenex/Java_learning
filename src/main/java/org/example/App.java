package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;
import java.util.Arrays;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args)
            throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Car realCar = new Car("Lada", "2107", 1980, 323456, 150000, "Гамовенко Дмитрий Нельвович", "Тел +79031234567");
        logger.info("Car без рефлексии: {}", realCar);
        logger.info("Задание 1 Reflection API");

        // 1. Получение класса (3 способа)
        Class<?> carClass = Car.class;
        Class<?> carClass2 = Class.forName("org.example.Car");
        Class<?> carClass3 = realCar.getClass();
        logger.info("1. Получения класса: {} / {} / {}",carClass.getName(), carClass2.getSimpleName(), carClass3.getPackage());

        // 2. Получение всех конструкторов (список)
        Constructor<?>[] constructors = carClass.getDeclaredConstructors();
        logger.info("2. Все конструкторы класса: {}", Arrays.toString(constructors));

        // 3. Создание нового объекта
        Constructor<?> publicConstructor = carClass.getConstructor(
                String.class, String.class, Integer.class, Integer.class, Integer.class, String.class, String.class);
        Car reflectionCar = (Car) publicConstructor.newInstance(
                "Toyota", "Camry", 2006, 123456, 965000, "Рефлексов Апир Джавович", "exampleMail_123@yahoo.org");
        logger.info("3. Car с рефлексией: {}", reflectionCar);

        // 4. Получение методов (список)
        Field[] publicFields = carClass.getFields();
        Field[] allFields = carClass.getDeclaredFields();
        logger.info("4. Публичные поля: {}, \nВсе поля: {}", publicFields, allFields);

        // 5. Создание обьекта из приватного конструктора
        Constructor<?> privateConstructor = carClass.getDeclaredConstructor();
        privateConstructor.setAccessible(true);
        Car reflectionCar2 = (Car) privateConstructor.newInstance();

        reflectionCar2.brand = "Mitsubishi";
        reflectionCar2.model = "Lancer EVO 7";
        reflectionCar2.year = 2012;
        reflectionCar2.mileage = 189523;
        reflectionCar2.price = 1248921;

        // 6. Изменение приватных полей
        Field sellerName = reflectionCar2.getClass().getDeclaredField("sellerName");
        sellerName.setAccessible(true);
        sellerName.set(reflectionCar2, "Приватнов Пол Аксессович");

        Field sellerContact = reflectionCar2.getClass().getDeclaredField("sellerContact");
        sellerContact.setAccessible(true);
        sellerContact.set(reflectionCar2, "Тел: 89542782935, email: fieldGet97@gmail.com");

        logger.info("5-6. Car из приватного поля: {}", reflectionCar2);

        // 7. Получение конкретного приватного поля
        Object value = sellerName.get(reflectionCar2);
        logger.info("7. Чтение приватного поля без геттара: {}", value);

        // 8. Получение информации о (приватных) полях
        Field sellerContactInfo = carClass2.getDeclaredField("sellerContact");
        Object sellerContactName = sellerContactInfo.getName();
        Object sellerContactType = sellerContactInfo.getType();
        Object sellerContactModifiers = Modifier.toString(sellerContactInfo.getModifiers());

        logger.info("8. Инфа о приватном поле: Имя: {} Тип: {}, Модификаторы: {}",
                sellerContactName, sellerContactType, sellerContactModifiers);

        // 9. Вызов методов ( .invoke(null) для static методов )
        Method sellerVisitCard = carClass3.getMethod("sellerVisitCard");
        Object resul1 = sellerVisitCard.invoke(reflectionCar);

        Method fastDiscount = carClass3.getDeclaredMethod("fastDiscount");
        fastDiscount.setAccessible(true);
        Object result2 = fastDiscount.invoke(reflectionCar);

        logger.info("9. Вызов методов. sellerVisitCard: {}, fastDiscount: {}", resul1, result2);

        // 10. Информация о методе
        Object fastDiscountInfoName = fastDiscount.getName();
        Object fastDiscountInfoType = fastDiscount.getReturnType();
        Object fastDiscountInfoInfoModifier = Modifier.toString(fastDiscount.getModifiers());

        logger.info("10. Инфа о приватном методе: Имя: {} возвращаемый тип: {}, Модификаторы: {}",
                fastDiscountInfoName, fastDiscountInfoType, fastDiscountInfoInfoModifier);

        logger.info("Задание 2 Simple reflection parser");

        String jsonFile = "{" +
                "    \"title\": \"Дюна\"," +
                "    \"author\": \"Фрэнк Герберт\"," +
                "    \"year\": 1965," +
                "    \"genre\": \"Фантастика\"," +
                "    \"price\": 1470.50" +
                "  }";

        Book parseBook = (Book) MyParser.parse(jsonFile, Book.class);
        logger.info(parseBook.toString());

    }
}