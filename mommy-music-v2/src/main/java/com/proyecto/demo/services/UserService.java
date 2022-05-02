package com.proyecto.demo.services;

import com.proyecto.demo.entities.User;

import java.util.Optional;

public interface UserService {

    public Iterable<User> getAll();
    public Optional<User> findById(String id);
    public Optional<User> save(User user);
    public Optional<User> update(User user);
    public boolean delete(String id);
}
