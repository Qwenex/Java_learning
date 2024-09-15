package org.example.srategyPattern;

public class AchievingGoalBicycle implements Strategy {

    @Override
    public String achievingGoal(Integer distance) {
        Integer cost = 0;
        Integer time = distance / 20;
        return String.format("Поездка на велосипеде займет %s минут(ы). Стоимость: %s", time, cost);
    }
}
