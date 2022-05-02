package com.proyecto.demo.controllers;

import com.proyecto.demo.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mostrarPaginaRegistro(Model model){
        model.addAttribute("user",new User());
        return "index";
    }

}
