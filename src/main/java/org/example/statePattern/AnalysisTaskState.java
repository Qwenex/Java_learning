package org.example.statePattern;

/**
 * Анализ задачи
 */
public class AnalysisTaskState implements TaskState {

    @Override
    public String getNameState() {
        return "Анализ задачи";
    }

    public InProgressTaskState inProgressTask() {
        return new InProgressTaskState();
    }

    public DeleteTaskState deleteTask() {
        return new DeleteTaskState();
    }

    public DraftTaskState draftTask() {
        return new DraftTaskState();
    }

}
