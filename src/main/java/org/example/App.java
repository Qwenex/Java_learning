package org.example;

import java.util.Random;

public class App {

    /**
     * Вывод значений массива
     * @param arrayName Массив, значения которого нужно вывести
     */
    public static void printArray(int[] arrayName) {
        String str = "( ";
        for (int i = 0; i < arrayName.length; i++) {
            str += arrayName[i] + " ";
        }
        System.out.println(str + ")");
    }

    /**
     * Задание 1. Рандомный массив с заданным min и max значением.
     * @param l Длина массива
     * @param a Минимальное значение массива
     * @param b Максимальное значение массива
     * @return Рандомный массив с заданной длиной, min и max значением
     */
    public static int[] randomArray(int l, int a, int b) {
        int[] array = new int[l];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(b - a + 1) + a;
        }
        return array;
    }

    /**
     * Задание 2. Отсортировать массив с помощью Bubble Sort.
     * @param array Неотсортированный массив
     * @return Отсортированный массив
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = 1; i > 0; i--) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int x = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = x;
                }
                i++;
            }
        }
        return array;
    }

    // v2
    public static int[] bubbleSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;
    }

    /**
     * Задание 3. Сумма всех элементов в массиве
     * @param array Массив в котором необходимо сложить элементы.
     * @return Сумма всех элементов
     */
    public static int sumInArray(int[] array) {
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            x += array[i];
        }
        return x;
    }

    /**
     * Задание 4. Вывести все четные элементы массива
     * @param array Массив в котором необходимо вывести все четные числа
     * @return Четные числа массива
     */
    public static String evenInArray(int[] array) {
        String str = "( ";
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                str += array[i] + " ";
            }
        }
        return (str += ")");
    }

    public static void main(String[] args) {

        int[] testArray = new int[]{4, 2, 1, 6, 3, 5, 10, 8, 9, 7};

        // Задание 1. Рандомный массив
        printArray(randomArray(6, 3, 9));

        // Задание 2. Bubble Sort
        printArray(bubbleSort2(testArray));

        // Задание 3. Сумма всех элементов в массиве
        System.out.println(sumInArray(testArray));

        // Задание 4. Четные элементы массива
        System.out.println(evenInArray(testArray));


    }
}