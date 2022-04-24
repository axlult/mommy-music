package com.cenfotec.mommysmusic.mommysmusic.service;

import com.cenfotec.mommysmusic.mommysmusic.domain.User;
import com.cenfotec.mommysmusic.mommysmusic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UserRepository userRepository;
    public void saveUser(User user){

    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById (int id) {
        return userRepository.findById(Long.valueOf(id));
    }



}
