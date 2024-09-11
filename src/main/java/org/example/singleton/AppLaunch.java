package org.example.singleton;

/**
 * Имитация запуска приложения
 */
public class AppLaunch {

    public AppLaunch() {
        System.out.println("Запуск приложения 15%...");
        System.out.println("Запуск приложения 38%...");
        System.out.println("Запуск приложения 59%...");
        System.out.println("Запуск приложения 98%...");
        System.out.println("Приложение запущено успешно");
    }

    public void SetConfig() {
        System.out.println("Внесены новые параметры приложения");
    }

    public void Status() {
        System.out.println("Приложение работает в штатном режиме");
    }

}
