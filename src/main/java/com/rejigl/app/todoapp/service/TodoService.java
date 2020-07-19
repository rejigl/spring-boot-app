package com.rejigl.app.todoapp.service;

import com.rejigl.app.todoapp.model.Todo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class TodoService {

    private static List<Todo> todoList = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todoList.add(new Todo(1, "Learn Spring MVC", "admin", "",  new Date(),false));
        todoList.add(new Todo(2, "Learn Struts", "admin", "", new Date(), false));
        todoList.add(new Todo(3, "Learn Hibernate", "admin", "", new Date(),false));
    }

    public int addTodo(String title, String name, String desc, Date targetDate, boolean isDone){
        int newId = todoList.size()+1;
        todoList.add(new Todo(newId, title , name, desc, targetDate, isDone));
        return newId;
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todoList.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todoList) {
            if (todo.getUsername().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public Optional<Todo> retrieveTodo(int id) {
        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                return Optional.of(todo);
            }
        }
        return Optional.empty();
    }

    public void updateTodo(Todo todo){
        todoList.remove(todo);
        todoList.add(todo);
    }
}
