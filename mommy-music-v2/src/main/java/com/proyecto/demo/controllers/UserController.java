package com.proyecto.demo.controllers;

import com.proyecto.demo.entities.User;
import com.proyecto.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List getAll(){
        return userService.getAll();
    }

    //Obtiene lista de usuarios en formato json deserializado para pruebas en Postman
    @GetMapping(value ="/lista", produces = "application/json")
    public @ResponseBody
    List getAllDeserialized(){
        return userService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<User> findById(@PathVariable long id){
        Optional<User> result = userService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user).get();
    }

    //Crear usuario en la pagina de login/registro
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String accionPaginaInsertar(User user, BindingResult result, Model model){
        System.out.println(user.toString());
        userService.save(user);
        return "logged";
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable("id") long id, @RequestBody User user){
        user.setId(id);
        Optional<User> result = userService.update(user);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        if (userService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
