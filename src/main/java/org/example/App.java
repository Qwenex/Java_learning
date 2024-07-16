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

    /**
     * Задание 2. Определить, является ли год високосным.
     * @param x Год
     * @return Високосность
     */
    public static String leapYear(int x) {
        printS("2) Год " + x + " является");
        if (x % 4 == 0) {
            if (x % 100 == 0) {
                if (x % 400 == 0) {
                    return "високосным.";
                } else {
                    return "не високосным.";
                }
            } else {
                return "високосным.";
            }
        } else {
            return "не високосным.";
        }
    }

    /**
     * Задание 3. Вывести значение функции (4*(x - 5)^2 + 7*x – 10)/(x^4+1)
     * @param x Неизвестное число x
     * @return Значение функции
     */
    public static Double func(double x) {
        printS("3) Значение функции (4*(x - 5)^2 + 7*x – 10)/(x^4+1) равно");
        double f;
        f = (4 * (Math.pow(x - 5, 2) + 7 * x - 10) / (Math.pow(x, 4) + 1));
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
                return "второй четверти.";
            } else {
                return "четвертой четверти.";
            }
        } else {
            if (y > 0) {
                return "первой четверти.";
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
        printS("5) Треугольник со сторонами (" + a + ") (" + b + ") (" + c + ")");
        if ((a + b >= c) && (a + c >= b) && (b + c >= a)) {
            return " существует!";
        } else {
            return "НЕ существует!";
        }
    }

    /**
     * Задание 6*. Решить квадратное уравнение ax^2 + bx + c = 0
     * @param a Число a
     * @param b Число b
     * @param c Число c
     * @return Корни уровнения x1 и x2
     */
    public static String func2(double a, double b, double c) {
        printS("6) Уравнение " + a + "(x^2)" + b + "x+" + c + " = 0 Имеет корни:");
        double x1;
        double x2;
        double d;
        d = (Math.pow(b, 2) - 4 * a * c);
        x1 = ((-b + Math.sqrt(d)) / 2 * a);
        x2 = ((-b - Math.sqrt(d)) / 2 * a);
        return x1 + " и " + x2;
    }

    /**
     * Задание 7* Закончить фразу “У меня в кармане...” “n монет”, “n монета”, “n монеты”
     * @param n Количество монет
     * @return Окончание фразы
     */
    public static String coins(int n) {
        printS("7) У меня в кармане");
        int y = (n % 10);
        if (y == 1 && n != 11) {
            return n + " монета";
        } else {
            if ((y>= 2 && y <= 4)  && !(n>=12 && n<= 14)) {
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
        printS("8) Вы ввели числа " + a + ", " + b + ", " + c + " | Числа в порядке возрастания:");
        if (a > b) {
            if (a > c) {
                if (b > c) {
                    return c + ", " + b + ", " + a;
                } else {
                    return b + ", " + c + ", " + a;
                }
            } else {
                return b + ", " + a + ", " + a;
            }
        } else {
            if (b > c) {
                if (a > c) {
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

        //Задание 2 Високосный год
        printS(leapYear(2000));

        //Задание 3 Значение функции
        System.out.println(func(7.861));

        //Задание 4 График
        printS(quarterChart(-5.3, 2.1));

        //Задание 5 Треугольник
        printS(triangle(7.3, 2.4, 4.7));

        //Задание 6 Корни квадратного уравнения
        printS(func2(3, -5, 2));

        //Задание 7 Монеты
        printS(coins(13));

        //Задание 8 Возрастание
        printS(increase(43.73, -981.2, 3.14));

    }
}
