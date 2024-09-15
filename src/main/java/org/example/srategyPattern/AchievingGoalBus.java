package org.example.srategyPattern;

public class AchievingGoalBus implements Strategy {

    @Override
    public String achievingGoal(Integer distance) {
        Integer cost = 35;
        Integer time = distance / 40;
        return String.format("Поездка на автобусе займет %s минут(ы). Стоимость: %s", time, cost);
    }
}
