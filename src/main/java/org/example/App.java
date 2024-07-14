package org.example;

public class App {

    /**
     *Быстрый вывод
     * @param number То что нужно вывести
     */
    public static void print(Integer number) {
        System.out.println(number);
    }

    /**
     * Задание 1. Найти наименьшее из 3-х чисел
     * @param x Первое число
     * @param y Второе число
     * @param z Третье число
     * @return Наименьшее число
     */
    public static Integer minNumber(int x,int y,int z) {
        if ((x < y) && (x < z)) {
            return x;
        } else {
            if (y < z ) {
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










    public static void main(String[] args) {
// Задание 1 Наименьшее число
        print(minNumber(10,43,21));

    }
}
