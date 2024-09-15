package org.example.statePattern;

/**
 * Выполнение задачи.
 */
public class CompletedTaskState implements TaskState {

    @Override
    public String getNameState() {
        return "Задача выполнена!";
    }
}