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
        printS("1) Наименьшее число из " + x + ", " + y + ", " + z + " это");
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

    /**
     * Задание 3. Вывести значение функции (4*(x - 5)^2 + 7*x – 10)/(x^4+1)
     * @param x Неизвестное число x
     * @return Значение функции
     */
   public static Double func(double x) {
       printS("3) Значение функции (4*(x - 5)^2 + 7*x – 10)/(x^4+1) равно");
       double f = ((4*((x - 5)*(x-5)) + 7*x-10)/(x*x*x*x+1));
       return f;
   }

    /**
     * Задание 4. Определить четверть графика по точке (x,y)
     * @param x Точка x
     * @param y Точка y
     * @return Ответ в какой четверти точка(x, y)
     */
    public static String quarterChart(double x, double y) {
        printS("4) Точка (" + x + "; " + y + ") находится в");
        if (x > 0) {
            if (y > 0) {
                return "второй четверти";
            } else {
                return "четвертой четверти";
            }
        } else {
            if (y > 0) {
                return "первой четверти";
            } else {
                return "третьей четверти";
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
    public static String trinagle(double a, double b, double c) {
        printS("5) Треугольник со сторонами (" + a + ") (" + b + ") (" + c + ")");
        if ((a + b >= c) && (a + c >= b) && (b + c >= a)) {
            return " существует!";
        } else {
            return "НЕ существует!";
        }
    }

/*
    public static double func2(double a, double b, double c) {

    }
*/






    /* 7
    public static String coins(int n) {
        printS("У меня в кармане");


    }







*/

    /**
     * Задание 8*. Расположить 3 числа в порядке возростания.
     * @param a Первое число
     * @param b Второе число
     * @param c Третье число
     * @return Три числа в порядке возрастания
     */
    public static String increase(double a, double b, double c) {
        printS("8) Вы ввели числа " + a + ", " + b + ", " + c + " | Числа в порядке возрастания:");
        if (a>b) {
            if (a>c) {
                if (b>c){
                    return c + ", " + b + ", " + a;
                } else {
                    return b + ", " + c + ", " + a;
                }
            } else {
                return b + ", " + a + ", " + a;
            }
        } else {
            if (b>c) {
                if (a>c) {
                    return c + ", " + a + ", " + b;
                } else {
                    return a + ", " + c + ", " + b;
                }
            } else {
                return a + ", " + b + ", " + c;
            }
        }
    }

    /**
     * Основной блок выполнения программы task 3
     * @param args Аргументы
     */
    public static void main(String[] args) {

        // Задание 1 Наименьшее число
        print(minNumber(10, -43, 21));

        //Задание 3 Значение функции
        System.out.println(func(7));

        //Задание 4 График
        printS(quarterChart(-5.3, 2.1));

        //Задание 5 Треугольник
        printS(trinagle(7.3, 2.4, 4.7));

        //Задание 8 Возрастание
        printS(increase(43.73,-981.2,3.14));

    }
}
