package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    public static Logger logger = LoggerFactory.getLogger(App.class);

    /**
     * Логгер числа double
     * @param number Число которое нужно вывести
     */
    public static void print(double number) {
        logger.info(String.valueOf(number));
    }

    /**
     * Логгер строки
     * @param symbol Строка которую нужно вывести
     */
    public static void print(String symbol) {
        logger.info(symbol);
    }

    /**
     * Задание 1. Найти наименьшее из 3-х чисел
     * @param x Первое число
     * @param y Второе число
     * @param z Третье число
     * @return Наименьшее число
     */
    public static double minNumber(double x, double y, double z) {
        print(String.format("1) Наименьшее число из %s, %s, %s это ", x, y, z));
        return (x < y) && (x < z) ? x : y < z ? y : z;
    }

    /**
     * Задание 2. Определить, является ли год високосным.
     * @param y Год
     * @return Високосность
     */
    public static String leapYear(int y) {
        print(String.format("2) Год %s является ", y));
        return (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0) ? "високосным" : "не високосным");
    }

    /**
     * Задание 3. Вывести значение функции (4*(x - 5)^2 + 7*x – 10)/(x^4+1)
     * @param x Неизвестное число x
     * @return Значение функции
     */
    public static Double func(double x) {
        print(String.format("3) Значение функции (4*(x - 5)^2 + 7*x – 10)/(x^4+1) при x = %s равно", x));
        return (4 * (Math.pow(x - 5, 2) + 7 * x - 10) / (Math.pow(x, 4) + 1));
    }

    /**
     * Задание 4. Определить четверть графика по точке (x,y)
     * @param x Точка x
     * @param y Точка y
     * @return Ответ в какой четверти точка(x, y)
     */
    public static String quarterChart(double x, double y) {
        print(String.format("4) Точка (%s; %s) находится в", x, y));
        if (x > 0) {
            if (y > 0) {
                return "первой четверти.";
            } else {
                return "четвертой четверти.";
            }
        } else {
            if (y > 0) {
                return "второй четверти.";
            } else {
                return "третьей четверти.";
            }
        }
    }

    /**
     * Задание 5. Существует ли треугольник со сторонами a, b, c ?
     * @param a Сторона a
     * @param b Сторона b
     * @param c Сторона c
     * @return Ответ о существовании треугольника
     */
    public static String triangle(double a, double b, double c) {
       print(String.format("5) Треугольник со сторонами %s; %s; %s; ", a, b, c));
        return (a + b >= c && a + c >= b && b + c >= a ? " существует!" : "НЕ существует!");
    }

    /**
     * Задание 6*. Решить квадратное уравнение ax^2 + bx + c = 0
     * @param a Число a
     * @param b Число b
     * @param c Число c
     * @return Корни уровнения x1 и x2
     */
    public static String quadraticEquation(int a, int b, int c) {
        print(String.format("6) Уравнение %s(x^2)+ %sx+ %s = 0 Имеет корни:", a, b, c));
        double d = (Math.pow(b, 2) - 4 * a * c);
        double x1 = ((-b + Math.sqrt(d)) / 2 * a);
        double x2 = ((-b - Math.sqrt(d)) / 2 * a);
        return d == 0 ? "Один корень: " + x1 : x1 + " и " + x2;
    }

    /**
     * Задание 7* Закончить фразу “У меня в кармане...” “n монет”, “n монета”, “n монеты”
     * @param n Количество монет
     * @return Окончание фразы
     */
    public static String coins(int n) {
        print("7) У меня в кармане");
        int y = (n % 10);
        if (y == 1 && n != 11) {
            return n + " монета";
        } else {
            if ((y >= 2 && y <= 4) && !(n >= 12 && n <= 14)) {
                return n + " монеты";
            } else {
                return n + " монет";
            }
        }
    }

    /**
     * Задание 8*. Расположить 3 числа в порядке возростания.
     * @param a Первое число
     * @param b Второе число
     * @param c Третье число
     * @return Три числа в порядке возрастания
     */
    public static String increase(double a, double b, double c) {
      print(String.format("8) Вы ввели числа %s, %s, %s | Числа в порядке возрастания:", a, b, c));
        double x;
        if (a > b) {
            x = a;
            a = b;
            b = x;
        }
        if (b > c) {
            x = b;
            b = c;
            c = x;
        }
        if (a > b) {
            x = a;
            a = b;
            b = x;
        }
        return String.format("%s; %s; %s;", a, b, c);
    }

    /**
     * Основной блок выполнения программы task 3
     * @param args Аргументы
     */
    public static void main(String[] args) {

        // Задание 1 Наименьшее число
        print(minNumber(10.96, -43.24, 0.56));

        //Задание 2 Високосный год
        print(leapYear(2000));

        //Задание 3 Значение функции
        print(func(7.861));

        //Задание 4 График
        print(quarterChart(-5.3, 2.1));

        //Задание 5 Треугольник
        print(triangle(7.3, 2.4, 4.7));

        //Задание 6 Корни квадратного уравнения
        print(quadraticEquation(3, -5, 2));

        //Задание 7 Монеты
        print(coins(13));

        //Задание 8 Возрастание
        print(increase(7.16, -5.98, 3.14));

    }
}
