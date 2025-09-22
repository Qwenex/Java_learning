package org.example.service;

import org.example.entity.TodoEntity;
import org.example.exception.TodoNotFoundException;
import org.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     * Добавление новой задачи
     * @param title       Название
     * @param description Описание
     * @return новый TodoItem
     */
    public TodoEntity addTodo(String title, String description) {
        TodoEntity newTodo = new TodoEntity(title, description);
        return todoRepository.save(newTodo);
    }
    /**
     * Получение задачи по id
     * @param id - id задачи
     * @return Задача с заданным id
     */
    public TodoEntity getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new TodoNotFoundException(id));
    }

    /**
     * Получение списка всех задач
     * @return Список всех задач (SELECT * FROM Table)
     */
    public List<TodoEntity> getAllTodos() {
        return todoRepository.findAll();
    }

    /**
     * Получение списка активных задач
     * @return Список невыполненых задач
     */
    public List<TodoEntity> getActiveTodos() {
        return todoRepository.findByCompletedFalse();
    }

    /**
     * Получение списка завершенных задач
     * @return Список выполненных задач
     */
    public List<TodoEntity> getCompletedTodos() {
        return todoRepository.findByCompletedTrue();
    }

    /**
     * Отметка об выполнении задачи
     * @param id - id задачи
     * @return Задача с обновленным статусом
     */
    public TodoEntity completeTodo(Long id) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(() ->
                new TodoNotFoundException(id));
        todoEntity.setCompleted(true);
        return todoRepository.save(todoEntity);
    }

    /**
     * Отметка об отмене выполнении задачи
     * @param id - id задачи
     * @return Задача с обновленным статусом
     */
    public TodoEntity unCompleteTodo(Long id) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(() ->
                new TodoNotFoundException(id));
        todoEntity.setCompleted(false);
        return todoRepository.save(todoEntity);
    }

    /**
     * Удаление задачи из списка
     * @param id - id задачи
     * @return Сообщение об результате операции
     */
    public String deleteTodo(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return String.format("Задача с id %s удалена", id);
        }
        return String.format("Задача с id %s была не найдена", id);
    }
}