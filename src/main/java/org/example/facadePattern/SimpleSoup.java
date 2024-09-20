package org.example.facadePattern;

import org.example.facadePattern.complexSoup.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-фасад для complexSoup (Имитация создания супа)
 */
public class SimpleSoup {
    private WaterSoupIngredient waterSoup;
    private PotatoSoupIngredient potatoSoup;
    private CarrotSoupIngredient carrotSoupIngredient;
    private ChickenSoupIngredient chickenSoupIngredient;
    private PastaSoupIngredient pastaSoupIngredient;
    private SpicesSoupIngredient spicesSoupSalt;
    private SpicesSoupIngredient spicesSoupPepper;

    public String cookSimpleSoup() {
        waterSoup = new WaterSoupIngredient("Фильтрованная", 2.5);
        potatoSoup = new PotatoSoupIngredient("Крупный", 2);
        carrotSoupIngredient = new CarrotSoupIngredient("Деревенская", 2);
        chickenSoupIngredient = new ChickenSoupIngredient("Вкусные дела. Сочные ножки", 2);
        spicesSoupSalt = new SpicesSoupIngredient("Соль пищевая", 3);
        spicesSoupPepper = new SpicesSoupIngredient("Перец черный", 2);

        waterSoup.boilWater(300);
        potatoSoup.cutPotato();
        potatoSoup.cookPotato(200);
        carrotSoupIngredient.cutCarrot();
        carrotSoupIngredient.cookCarrot(200);
        chickenSoupIngredient.cutChicken();
        chickenSoupIngredient.cookChicken(400);

        List<Object> simpleSoup = new ArrayList<>();
        simpleSoup.add(waterSoup);
        simpleSoup.add(potatoSoup);
        simpleSoup.add(carrotSoupIngredient);
        simpleSoup.add(chickenSoupIngredient);
        simpleSoup.add(spicesSoupSalt);
        simpleSoup.add(spicesSoupPepper);

        return String.format("Cуп готов! Приятного аппетита! Рецепт: %s", simpleSoup);
    }

    public String cookSimplePastaSoup() {
        waterSoup = new WaterSoupIngredient("Фильтрованная очищенная", 3.0);
        potatoSoup = new PotatoSoupIngredient("Средняя деревенская", 1);
        carrotSoupIngredient = new CarrotSoupIngredient("Деревенская", 1);
        chickenSoupIngredient = new ChickenSoupIngredient("Вкусные дела. Большие грудки", 2);
        pastaSoupIngredient = new PastaSoupIngredient("Спагетти", 1);
        spicesSoupSalt = new SpicesSoupIngredient("Соль", 2);
        spicesSoupPepper = new SpicesSoupIngredient("Перец", 3);

        waterSoup.boilWater(200);
        potatoSoup.cutPotato();
        potatoSoup.cookPotato(150);
        carrotSoupIngredient.cutCarrot();
        carrotSoupIngredient.cookCarrot(150);
        chickenSoupIngredient.cutChicken();
        chickenSoupIngredient.cookChicken(350);
        pastaSoupIngredient.cookPasta(200);

        List<Object> simplePastaSoup = new ArrayList<>();
        simplePastaSoup.add(waterSoup);
        simplePastaSoup.add(potatoSoup);
        simplePastaSoup.add(carrotSoupIngredient);
        simplePastaSoup.add(chickenSoupIngredient);
        simplePastaSoup.add(pastaSoupIngredient);
        simplePastaSoup.add(spicesSoupSalt);
        simplePastaSoup.add(spicesSoupPepper);

        return String.format("Cуп-лапша готов! Приятного аппетита! Рецепт: %s", simplePastaSoup);
    }

}
