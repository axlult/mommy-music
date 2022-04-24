package com.cenfotec.mommysmusic.mommysmusic.controller;

import com.cenfotec.mommysmusic.mommysmusic.domain.User;
import com.cenfotec.mommysmusic.mommysmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List getAll(){
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
