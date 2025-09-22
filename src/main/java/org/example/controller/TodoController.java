package org.example.controller;

import org.example.entity.TodoEntity;
import org.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * Добавление новой задачи
     * @param request 'Body' запрос
     * @return Созданная задача
     */
    @PostMapping("/add")
    public TodoEntity addTodo(@RequestBody TodoEntity request) {
        return todoService.addTodo(request.getTitle(), request.getDescription());
    }

    /**
     * Получение задачи по id
     * @param id - id задачи
     * @return Задача с заданным id
     */
    @GetMapping("/get")
    public ResponseEntity<?> getTodoById(@RequestParam Long id) {
          return ResponseEntity.ok(todoService.getTodoById(id));
    }

    /**
     * Получение списка всех задач
     * @return Список всех задач (SELECT * FROM Table)
     */
    @GetMapping("/getAll")
    public List<TodoEntity> getAllTodos() {
        return todoService.getAllTodos();
    }

    /**
     * Получение списка активных задач
     * @return Список невыполненых задач
     */
    @GetMapping("/getActive")
    public List<TodoEntity> getActiveTodos() {
        return todoService.getActiveTodos();
    }

    /**
     * Получение списка завершенных задач
     * @return Список выполненных задач
     */
    @GetMapping("/getCompleted")
    public List<TodoEntity> getCompletedTodos() {
        return todoService.getCompletedTodos();
    }

    /**
     * Отметка об выполнении задачи
     * @param id - id задачи
     * @return Задача с обновленным статусом
     */
    @PostMapping("/complete")
    public ResponseEntity<?> completeTodo(@RequestParam Long id) {
            return ResponseEntity.ok(todoService.completeTodo(id));
    }

    /**
     * Отметка об отмене выполнении задачи
     * @param id - id задачи
     * @return Задача с обновленным статусом
     */
    @PostMapping("/unComplete")
    public ResponseEntity<?> unCompleteTodo(@RequestParam Long id) {
            return ResponseEntity.ok(todoService.unCompleteTodo(id));
    }

    /**
     * Удаление задачи из списка
     * @param id - id задачи
     * @return Сообщение об результате операции
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTodo(@RequestParam Long id) {
            return ResponseEntity.ok(todoService.deleteTodo(id));
    }
}
