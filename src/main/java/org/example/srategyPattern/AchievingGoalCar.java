package org.example.srategyPattern;

public class AchievingGoalCar implements Strategy {

    @Override
    public String achievingGoal(Integer distance) {
        Double cost = distance * 0.25;
        Integer time = distance / 70;
        return String.format("Поездка на машине займет %s минут(ы). Стоимость: %s", time, cost);
    }
}
