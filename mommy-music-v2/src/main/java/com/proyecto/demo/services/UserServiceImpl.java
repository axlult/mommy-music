package com.proyecto.demo.services;

import com.proyecto.demo.entities.User;
import com.proyecto.demo.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<User> update(User user) {
        Optional<User> record = userRepository.findById(user.getId());
        if (record.isPresent()) {
            User data = record.get();
            data.setName(user.getName());
            data.setFirstName(user.getFirstName());
            data.setLastName(user.getLastName());
            data.setEmail(user.getEmail());
            data.setGender(user.getGender());
            data.setBirthDate(user.getBirthDate());
            return Optional.of(userRepository.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
