package org.example.singleton;

/**
 * Паттерн Singleton.
 * Единственность класса запуска приложения.
 */
public class AppLaunchSingleton {

    private static AppLaunch appLaunch;

    public static AppLaunch getInstant() {
        if (appLaunch == null) {
            appLaunch = new AppLaunch();
        }
        return appLaunch;
    }
}
