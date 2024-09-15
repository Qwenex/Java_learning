package org.example.statePattern;

/**
 * В процессе выполнения задачи
 */
public class InProgressTaskState implements TaskState {

    @Override
    public String getNameState() {
        return "В ходе выполнения задачи";
    }

    public CompletedTaskState completedTask() {
        return new CompletedTaskState();
    }

    public DeleteTaskState deleteTask() {
        return new DeleteTaskState();
    }

    public DraftTaskState draftTask() {
        return new DraftTaskState();
    }

}