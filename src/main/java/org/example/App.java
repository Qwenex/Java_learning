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
     * @param l   Длина массива
     * @param min Минимальное значение массива
     * @param max Максимальное значение массива
     * @return Рандомный массив с заданной длиной, min и max значением
     */
    public static int[] randomArray(int l, int min, int max) {
        int[] array = new int[l];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(max - min + 1) + min;
        }
        return array;
    }

    /**
     * Задание 2. Отсортировать массив с помощью Bubble Sort.
     * @param array Неотсортированный массив
     * @return Отсортированный массив
     */
    public static int[] bubbleSort(int[] array) {
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
    public static int sumElementArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Задание 4. Вывести все четные элементы массива
     * @param array Массив в котором необходимо вывести все четные числа
     * @return Четные числа массива
     */
    public static String evenElementArray(int[] array) {
        String result = "( ";
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result += array[i] + " ";
            }
        }
        return (result += ")");
    }

    /**
     * Задание 5. “Удалить” первый элемент массива
     * @param array Искомый массив
     * @return Массив с удаленым 1-ым элементом
     */
    public static int[] deleteFirstArray(int[] array) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < array.length-1; i++) {
            newArray[i] = array[i+1];
        }
        return newArray;
    }

    /**
     * Задание 6. Вывести строку задом наоборот
     * @param str Строка, которую нужно перевернуть (пр."Привет")
     * @return Перевернутая строка (пр."тевирП")
     */
    public static String reverseString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result = str.charAt(i) + result;
        }
        return result;
    }

    /**
     * Задание 7* “Удалить” элемент из массива по индексу
     * @param array Искомый массив
     * @param deleteIndex Индекс массива, который нужно удалить
     * @return Массив с удаленным элементом
     */
    public static int[] deleteElementArray(int[] array, int deleteIndex) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < array.length-1; i++) {
            newArray[i] = i < deleteIndex ? array[i] : array[i+1];
        }
        return newArray;
    }

    public static void main(String[] args) {

        // Задание 1. Рандомный массив
        System.out.println("1) Рандомный массив");
        int[] rndArray = randomArray(6, 3, 9);
        printArray(rndArray);

        // Задание 2. Сортировка Bubble Sort
        System.out.println("2) Bubble Sort");
        printArray(bubbleSort(rndArray));

        // Задание 3. Сумма всех элементов в массиве
        System.out.println("3) Сумма \n" + sumElementArray(rndArray));

        // Задание 4. Четные элементы массива
        System.out.println("4) Четные числа \n" + evenElementArray(rndArray));

        // Задание 5. “Удалить” первый элемент массива
        System.out.println("5) Удаление 1-го элемента");
        printArray(deleteFirstArray(rndArray));

        // Задание 6. Вывести строку задом наоборот
        System.out.println("6) Реверс строки \n" + reverseString("4321 dcbA"));

        // Задание 7*. "Удалить” элемент из массива
        System.out.println("7*) Удаление элмента из массива");
        printArray(deleteElementArray(rndArray,5));

    }
}