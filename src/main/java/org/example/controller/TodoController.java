package org.example.controller;

import org.example.model.TodoItem;
import org.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/getAll")
    public Map<Integer, TodoItem> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping("/add")
    public TodoItem addTodo(@RequestBody TodoItem request) {
        return todoService.addTodo(request.getTitle(), request.getDescription());
    }

    @PostMapping("/complete")
    public String completeTodo(@RequestParam Integer id) {
        return todoService.completeTodo(id);
    }

    @PostMapping("/unComplete")
    public String unCompleteTodo(@RequestParam Integer id) {
        return todoService.unCompleteTodo(id);
    }

    @DeleteMapping("/delete")
    public String deleteTodo(@RequestParam Integer id) {
        return todoService.deleteTodo(id);
    }

}
