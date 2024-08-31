package org.example;

/**
 * Enum класс Цвет (RGB)
 */
public enum Color {

    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    WHITE(255, 255, 255),
    BRONZE(160, 82, 45),
    SILVER(192, 192, 192),
    GOLD(255, 215, 0),
    AQUA(0, 255, 255),
    YELLOW(255, 255, 0),
    ORANGE(255, 69, 0),
    PINK(255, 20, 147),
    NAVY(0, 0, 128),
    MAROON(128, 0, 0);

   private final Integer red;
   private final Integer green;
   private final Integer blue;

    Color(Integer red, Integer green, Integer blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String getRGB() {
        return String.format("%s %s %s", red, green, blue);
    }
}