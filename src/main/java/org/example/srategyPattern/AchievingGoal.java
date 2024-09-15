package org.example.srategyPattern;

public class AchievingGoal {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    /**
     * Выбор стратегии
     * @param strategy Выбираемая стратегия использования транспорта
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Расчет времени и стоимости поездки.
     * @param distance Дистанция до цели
     * @return Метод расчитывания времени и стоимости поездки выбранной стратегии.
     */
   public String AchievingGoalStrategy(Integer distance) {
        return strategy.achievingGoal(distance);
    }
}
