package org.example;

import java.util.Random;

public class App {

    /**
     * Вывод значений массива
     * @param arrayName Массив, значения которого нужно вывести
     */
    public static void printArray(int[] arrayName) {
        String str = "(";
        for (int i = 0; i < arrayName.length; i++) {
            str += arrayName[i] + " ";
        }
        System.out.println(str + ")");
    }

    /**
     * Задание 1
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

    public static void main(String[] args) {

        // for tests
        int[] array23 = {2, 6, 1, 8, 3};
        printArray(array23);
        System.out.println();

        // Задание 1. Рандомный массив
        printArray(randomArray(5,3,9));


    }
}