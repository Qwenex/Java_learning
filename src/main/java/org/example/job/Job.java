package org.example.job;

/**
 * Абстракный класс работа
 */
public abstract class Job {

    public abstract String getNameJob();

    @Override
    public String toString() {
        return getNameJob();
    }
}