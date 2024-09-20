package org.example.facadePattern;

import org.example.facadePattern.complexSoup.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-фасад для complexSoup (Имитация создания супа)
 */
public class SimpleSoup {
    private WaterSoup waterSoup;
    private PotatoSoup potatoSoup;
    private CarrotSoup carrotSoup;
    private ChickenSoup chickenSoup;
    private PastaSoup pastaSoup;
    private SpicesSoup spicesSoupSalt;
    private SpicesSoup spicesSoupPepper;

    public String cookSimpleSoup() {
        waterSoup = new WaterSoup("Фильтрованная", 2.5);
        potatoSoup = new PotatoSoup("Крупный", 2);
        carrotSoup = new CarrotSoup("Деревенская", 2);
        chickenSoup = new ChickenSoup("Вкусные дела. Сочные ножки", 2);
        spicesSoupSalt = new SpicesSoup("Соль пищевая", 3);
        spicesSoupPepper = new SpicesSoup("Перец черный", 2);

        waterSoup.boilWater(300);
        potatoSoup.cutPotato();
        potatoSoup.cookPotato(200);
        carrotSoup.cutCarrot();
        carrotSoup.cookCarrot(200);
        chickenSoup.cutChicken();
        chickenSoup.cookChicken(400);

        List<Object> simpleSoup = new ArrayList<>();
        simpleSoup.add(waterSoup);
        simpleSoup.add(potatoSoup);
        simpleSoup.add(carrotSoup);
        simpleSoup.add(chickenSoup);
        simpleSoup.add(spicesSoupSalt);
        simpleSoup.add(spicesSoupPepper);

        return "Cуп готов! Приятного аппетита! Рецепт: " + simpleSoup;
    }

    public String cookSimplePastaSoup() {
        waterSoup = new WaterSoup("Фильтрованная очищенная", 3.0);
        potatoSoup = new PotatoSoup("Средняя деревенская", 1);
        carrotSoup = new CarrotSoup("Деревенская", 1);
        chickenSoup = new ChickenSoup("Вкусные дела. Большие грудки", 2);
        pastaSoup = new PastaSoup("Спагетти", 1);
        spicesSoupSalt = new SpicesSoup("Соль", 2);
        spicesSoupPepper = new SpicesSoup("Перец", 3);

        waterSoup.boilWater(200);
        potatoSoup.cutPotato();
        potatoSoup.cookPotato(150);
        carrotSoup.cutCarrot();
        carrotSoup.cookCarrot(150);
        chickenSoup.cutChicken();
        chickenSoup.cookChicken(350);
        pastaSoup.cookPasta(200);

        List<Object> simplePastaSoup = new ArrayList<>();
        simplePastaSoup.add(waterSoup);
        simplePastaSoup.add(potatoSoup);
        simplePastaSoup.add(carrotSoup);
        simplePastaSoup.add(chickenSoup);
        simplePastaSoup.add(pastaSoup);
        simplePastaSoup.add(spicesSoupSalt);
        simplePastaSoup.add(spicesSoupPepper);

        return "Cуп-лапша готов! Приятного аппетита! Рецепт: " + simplePastaSoup;
    }

}
