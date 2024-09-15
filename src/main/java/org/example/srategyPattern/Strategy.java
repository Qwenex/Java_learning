package org.example.srategyPattern;

/**
 * Интерфес стратегии достижения точки маршрута
 */
public interface Strategy {

    /**
     * Достижение точки маршрута
     * @param distance Расстояние
     * @return Расчетное время и стоимость поездки
     */
    String achievingGoal(Integer distance);
}
