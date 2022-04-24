package com.cenfotec.mommysmusic.mommysmusic.service;

import com.cenfotec.mommysmusic.mommysmusic.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAll();
    public Optional<User> findById(long id);
    public Optional<User> save(User user);
    public Optional<User> update(User user);
    public boolean delete(long id);
}
