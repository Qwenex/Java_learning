package org.example;

import org.example.builder.Pizza;
import org.example.builder.PizzaBuilder;
import org.example.prototype.ShoppingList;
import org.example.singleton.AppLaunch;
import org.example.singleton.AppLaunchSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("\n\n Задание 1. Singleton");
        AppLaunch appLaunch1 = AppLaunchSingleton.getInstant();
        appLaunch1.SetConfig();
        appLaunch1.Status();

        AppLaunch appLaunch2 = AppLaunchSingleton.getInstant();
        appLaunch2.SetConfig();

        AppLaunch appLaunch3 = AppLaunchSingleton.getInstant();
        appLaunch3.Status();

        logger.info("\n\n Задание 2. Builder");
        Pizza freshPizza = new PizzaBuilder()
                .withDough("Классическое 40 см")
                .withCheese("Российский")
                .withSauce("Фирменный соус")
                .withGreen("Петрушка и укроп")
                .withTomato("Черри")
                .withChicken("Medium rare")
                .withMushrooms("Шампиньон")
                .build();

        logger.info(freshPizza.toString());

        logger.info("\n\n Задание 3. Prototype");
        ShoppingList shoppingList = new ShoppingList("Молоко", 1, 100);

        ShoppingList shoppingListBread = (ShoppingList) shoppingList.copy();
        shoppingListBread.setNewItem("Хлеб", 2, 30);

        ShoppingList shoppingListSausages = (ShoppingList) shoppingList.copy();
        shoppingListSausages.setNewItem("Сосиски", 10, 140);

        ShoppingList shoppingListYogurt = (ShoppingList) shoppingList.copy();
        shoppingListYogurt.setNewItem("Йогурт", 4, 50);

        List<ShoppingList> shopList = new ArrayList<>();
        shopList.add(shoppingList);
        shopList.add((ShoppingList) shoppingList.copy());
        shopList.add(shoppingListBread);
        shopList.add(shoppingListSausages);
        shopList.add(shoppingListYogurt);

        int fullPrice = 0;
        for (int i = 0; i < shopList.size(); i++) {
            fullPrice += shopList.get(i).getPrice();
        }

        logger.info("{} \n Итоговая цена: {}", shopList, fullPrice);
    }
}
