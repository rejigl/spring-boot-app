package com.rejigl.app.todoapp.service;

import com.rejigl.app.todoapp.model.Todo;
import com.rejigl.app.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class TodoService {

    private static List<Todo> todoList = new ArrayList<Todo>();
    private static int todoCount = 3;

    @Autowired
    TodoRepository repository;

    public int addTodo(String title, String name, String desc, Date targetDate, boolean isDone){
        Todo todo = new Todo(title , name, desc, targetDate, isDone);
        todo = repository.save(todo);
        return todo.getId();
    }

    public void deleteTodo(int id) {
        repository.deleteById(id);
    }

    public List<Todo> retrieveTodos(String user) {
        return repository.findByUsername(user);
    }

    public Optional<Todo> retrieveTodo(int id) {
        return repository.findById(id);
    }

    public void updateTodo(Todo todo){
        repository.save(todo);
    }
}
