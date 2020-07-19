package com.rejigl.app.todoapp.controller;

import com.rejigl.app.todoapp.model.Todo;
import com.rejigl.app.todoapp.service.LoginService;
import com.rejigl.app.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {

    private final static String LOGIN_PAGE = "login";
    private final static String WELCOME_PAGE = "welcome";
    private final static String LIST_TODO_PAGE = "list-todo";
    private final static String TODO_PAGE = "upsert-todo";
    private final static String ERROR_PAGE = "error";

    @Autowired
    TodoService service;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/list-todo", method = RequestMethod.GET)
    public String showTodoListPage(ModelMap model){
        String name = (String)model.get("name");
        model.put("todos", service.retrieveTodos(name));
        return LIST_TODO_PAGE;
    }

    @RequestMapping(value = "/upsert-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model)
    {
        model.addAttribute("todo", new Todo(0, "",  (String)model.get("name"), "", Date.from(Instant.EPOCH), false));
        return TODO_PAGE;
    }

    @RequestMapping(value = "/upsert-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return TODO_PAGE;
        }

        service.addTodo(todo.getTitle(), (String)model.get("name"), todo.getDescription(), Date.from(Instant.EPOCH), false );
        return "redirect:/"+LIST_TODO_PAGE;
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        service.deleteTodo(id);
        return "redirect:/"+LIST_TODO_PAGE;
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam int id){
        Todo todo = service.retrieveTodo(id).get();
        model.put("todo", todo);
        return TODO_PAGE;
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return TODO_PAGE;
        }

        todo.setUsername((String)model.get("name"));
        service.updateTodo(todo);

        return "redirect:/"+ LIST_TODO_PAGE;
    }

}