package org.example.service;

import org.example.model.TodoItem;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TodoService {

    private final ConcurrentHashMap<Integer, TodoItem> todoMap = new ConcurrentHashMap<>();
    private final AtomicInteger globalId = new AtomicInteger(0);

    /**
     * Получение всех задач
     * @return HashMap со списком всех задач
     */
    public Map<Integer, TodoItem> getAllTodos() {
        return new HashMap<>(todoMap);
    }

    /**
     * Добавление новой задачи
     * @param title       Название
     * @param description Описание
     * @return новый TodoItem
     */
    public TodoItem addTodo(String title, String description) {
        Integer newId = globalId.getAndIncrement();
        TodoItem newTodo = new TodoItem(newId, title, description, false);
        todoMap.put(newId, newTodo);
        return newTodo;
    }

    /**
     * Отметка об выполнении задачи
     * @param id id требуемой задачи
     */
    public String completeTodo(Integer id) {
        TodoItem todoItem = todoMap.get(id);
        if (todoItem != null) {
            todoItem.setCompleted(true);
        } else {
            throw new NoSuchElementException("Задача с Id " + id + " не найдена");
        }
        return String.format("Здача %s отмечена как выполненная! =) ", id);
    }

    /**
     * Отметка об отмены выполнения задачи
     * @param id id требуемой задачи
     */
    public String unCompleteTodo(Integer id) {
        TodoItem todoItem = todoMap.get(id);
        if (todoItem != null) {
            todoItem.setCompleted(false);
        } else {
            throw new NoSuchElementException("Задача с Id " + id + " не найдена");
        }
        return String.format("Здача %s отмечена как НЕ выполненная. =( ", id);
    }

    /**
     * Удаление задачи
     * @param id id требуемой задачи
     */
    public String deleteTodo(Integer id) {
        if (todoMap.remove(id) == null) {
            throw new NoSuchElementException("Задача с Id " + id + " не найдена");
        }
        todoMap.remove(id);
        return String.format("Задача с id %s удалена", id);
    }
}