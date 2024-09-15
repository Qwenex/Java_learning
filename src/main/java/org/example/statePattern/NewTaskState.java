package org.example.statePattern;

/**
 * Новая задача
 */
public class NewTaskState implements TaskState {

    @Override
    public String getNameState() {
        return "Новая задача";
    }

    public AnalysisTaskState analysisTask() {
        return new AnalysisTaskState();
    }

    public DeleteTaskState deleteTask() {
        return new DeleteTaskState();
    }

}