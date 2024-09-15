package org.example;

import org.example.factoryPattern.Shop;
import org.example.factoryPattern.product.CheeseProduct;
import org.example.factoryPattern.product.ChocolateProduct;
import org.example.factoryPattern.product.SausageProduct;
import org.example.srategyPattern.AchievingGoal;
import org.example.srategyPattern.AchievingGoalBicycle;
import org.example.srategyPattern.AchievingGoalBus;
import org.example.srategyPattern.AchievingGoalCar;
import org.example.statePattern.NewTaskState;
import org.example.statePattern.TaskState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("\n\n Задание 1. Паттерн Factory");
        List<Shop> shops = new ArrayList<>();
        shops.add(new Shop("Шоколадный вход", new ChocolateProduct()));
        shops.add(new Shop("Соси сосиску", new SausageProduct()));
        shops.add(new Shop("Мышеловочка", new CheeseProduct()));

    logger.info(shops.toString());

        logger.info("\n\n Задание 2. Паттерн State");
        TaskState taskState =
                new NewTaskState()
                        .analysisTask()
                        .draftTask()
                        .newTask()
                        .analysisTask()
                        .inProgressTask()
                        .completedTask();

        logger.info(taskState.getNameState());

        logger.info("\n\n Задание 3. Паттерн Strategy");
        AchievingGoal achievingGoal = new AchievingGoal();

        achievingGoal.setStrategy(new AchievingGoalBicycle());
        logger.info(achievingGoal.AchievingGoalStrategy(1322));

        achievingGoal.setStrategy(new AchievingGoalBus());
        logger.info(achievingGoal.AchievingGoalStrategy(1322));

        achievingGoal.setStrategy(new AchievingGoalCar());
        logger.info(achievingGoal.AchievingGoalStrategy(1322));

    }
}