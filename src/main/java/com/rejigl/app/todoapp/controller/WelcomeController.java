package com.rejigl.app.todoapp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    private final static String LOGIN_PAGE = "login";
    private final static String WELCOME_PAGE = "welcome";
    private final static String ERROR_PAGE = "error";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model){

        model.put("name", getLoggedInUserName());
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


    private String getLoggedInUserName(){
        Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails)
            return ((UserDetails)principal).getUsername();

        return principal.toString();
    }
}