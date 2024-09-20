package org.example.facadePattern;

import org.example.facadePattern.complexSoup.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-фасад для complexSoup (Имитация создания супа)
 */
public class SimpleSoup {
    private WaterSoupIngredient waterSoupIngredient;
    private PotatoSoupIngredient potatoSoupIngredient;
    private CarrotSoupIngredient carrotSoupIngredient;
    private ChickenSoupIngredient chickenSoupIngredient;
    private PastaSoupIngredient pastaSoupIngredient;
    private SpicesSoupIngredient spicesSoupIngredientSalt;
    private SpicesSoupIngredient spicesSoupIngredientPepper;

    public String cookSimpleSoup() {
        waterSoupIngredient = new WaterSoupIngredient("Фильтрованная", 2.5);
        potatoSoupIngredient = new PotatoSoupIngredient("Крупный", 2);
        carrotSoupIngredient = new CarrotSoupIngredient("Деревенская", 2);
        chickenSoupIngredient = new ChickenSoupIngredient("Вкусные дела. Сочные ножки", 2);
        spicesSoupIngredientSalt = new SpicesSoupIngredient("Соль пищевая", 3);
        spicesSoupIngredientPepper = new SpicesSoupIngredient("Перец черный", 2);

        waterSoupIngredient.boilWater(300);
        potatoSoupIngredient.cutPotato();
        potatoSoupIngredient.cookPotato(200);
        carrotSoupIngredient.cutCarrot();
        carrotSoupIngredient.cookCarrot(200);
        chickenSoupIngredient.cutChicken();
        chickenSoupIngredient.cookChicken(400);

        List<Object> simpleSoup = new ArrayList<>();
        simpleSoup.add(waterSoupIngredient);
        simpleSoup.add(potatoSoupIngredient);
        simpleSoup.add(carrotSoupIngredient);
        simpleSoup.add(chickenSoupIngredient);
        simpleSoup.add(spicesSoupIngredientSalt);
        simpleSoup.add(spicesSoupIngredientPepper);

        return String.format("Cуп готов! Приятного аппетита! Рецепт: %s", simpleSoup);
    }

    public String cookSimplePastaSoup() {
        waterSoupIngredient = new WaterSoupIngredient("Фильтрованная очищенная", 3.0);
        potatoSoupIngredient = new PotatoSoupIngredient("Средняя деревенская", 1);
        carrotSoupIngredient = new CarrotSoupIngredient("Деревенская", 1);
        chickenSoupIngredient = new ChickenSoupIngredient("Вкусные дела. Большие грудки", 2);
        pastaSoupIngredient = new PastaSoupIngredient("Спагетти", 1);
        spicesSoupIngredientSalt = new SpicesSoupIngredient("Соль", 2);
        spicesSoupIngredientPepper = new SpicesSoupIngredient("Перец", 3);

        waterSoupIngredient.boilWater(200);
        potatoSoupIngredient.cutPotato();
        potatoSoupIngredient.cookPotato(150);
        carrotSoupIngredient.cutCarrot();
        carrotSoupIngredient.cookCarrot(150);
        chickenSoupIngredient.cutChicken();
        chickenSoupIngredient.cookChicken(350);
        pastaSoupIngredient.cookPasta(200);

        List<Object> simplePastaSoup = new ArrayList<>();
        simplePastaSoup.add(waterSoupIngredient);
        simplePastaSoup.add(potatoSoupIngredient);
        simplePastaSoup.add(carrotSoupIngredient);
        simplePastaSoup.add(chickenSoupIngredient);
        simplePastaSoup.add(pastaSoupIngredient);
        simplePastaSoup.add(spicesSoupIngredientSalt);
        simplePastaSoup.add(spicesSoupIngredientPepper);

        return String.format("Cуп-лапша готов! Приятного аппетита! Рецепт: %s", simplePastaSoup);
    }
}