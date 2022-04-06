package com.proyecto.demo.controllers;

import com.proyecto.demo.entities.User;
import com.proyecto.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("user", userService.getAll());
        return "index";
    }

    //GET
    @RequestMapping(value = "/agregarDatos", method = RequestMethod.GET)
    public String navegarPagina(Model model){
        model.addAttribute(new User());
        return "agregarDatos";
    }

    //POST
    @RequestMapping(value = "/agregarDatos", method = RequestMethod.POST)
    public String accionPagina(User user, BindingResult result, Model model){
        user.setCreated(Date.from(Instant.now()));
        userService.saveUser(user);
        return "agregarDatos";
    }

}
