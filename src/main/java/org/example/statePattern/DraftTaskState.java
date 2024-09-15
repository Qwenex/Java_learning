package org.example.statePattern;

/**
 * Отложение задачи в черновик
 */
public class DraftTaskState implements TaskState {

    @Override
    public String getNameState() {
        return "Отложение задачи";
    }

    public NewTaskState newTask() {
        return new NewTaskState();
    }
}