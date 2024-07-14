package org.example;

public class App {

    /**
     * Быстрый вывод числа
     * @param number Число которое нужно вывести
     */
    public static void print(Integer number) {
        System.out.println(number);
    }

    /**
     * Быстрый вывод строки
     * @param symbol Строка которую нужно вывести
     */
    public static void printS(String symbol) {
        System.out.println(symbol);
    }

    /**
     * Задание 1. Найти наименьшее из 3-х чисел
     * @param x Первое число
     * @param y Второе число
     * @param z Третье число
     * @return Наименьшее число
     */
    public static Integer minNumber(int x, int y, int z) {
        if ((x < y) && (x < z)) {
            return x;
        } else {
            if (y < z) {
                return y;
            } else {
                return z;
            }
        }
    }
   /* Задание 2
    public static Integer leapYear(int x) {
        return x;
    }
*/
    /* Задание 3
   public static Double func(double x, double y) {
       return y;
   }
 */

    /**
     * Задание 4. Определить четверть графика по точке (x,y)
     * @param x Точка x
     * @param y Точка y
     */
   public static void quarterChart(double x, double y) {
       if (x > 0) {
           if (y > 0) {
              printS("Вторая четверть");

           } else {
               printS("Четвертая четверть");
           }
       } else {
           if (y>0) {
               printS("Первая четверть");
           } else {
               printS("Третья четверть");
           }
       }
   }









    public static void main(String[] args) {
    // Задание 1 Наименьшее число
    print(minNumber(10,43,21));
    //Задание 4 График
    //print(quarterChart(5.3,-2.1));
    }
}
