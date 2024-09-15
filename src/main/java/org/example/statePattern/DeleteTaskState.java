package org.example.statePattern;

/**
 * Удаление задачи
 */
public class DeleteTaskState implements TaskState {

    @Override
    public String getNameState() {
        return "Удаление задачи";
    }
}