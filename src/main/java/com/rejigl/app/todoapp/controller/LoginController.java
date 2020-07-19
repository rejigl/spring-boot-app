package com.rejigl.app.todoapp.controller;

import com.rejigl.app.todoapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    private final static String LOGIN_PAGE = "login";
    private final static String WELCOME_PAGE = "welcome";
    private final static String ERROR_PAGE = "error";

    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return LOGIN_PAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model,
                                  @RequestParam String name,
                                  @RequestParam String password){

        model.put("name", name);

        if( !service.validateUser(name, password) ) {
            model.put("message", "Invalid Credentials :-(");
            return LOGIN_PAGE;
        }

        return WELCOME_PAGE;
    }

    @RequestMapping("/simplelogin")
    public String loginJSP(@RequestParam String name, ModelMap model){
        model.put("name", name);
        return LOGIN_PAGE;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String loginMessage(){
        return "Hello World";
    }
}