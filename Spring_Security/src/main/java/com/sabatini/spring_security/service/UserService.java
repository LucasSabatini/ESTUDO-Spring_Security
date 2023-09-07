package com.sabatini.spring_security.service;

import com.sabatini.spring_security.model.User;
import com.sabatini.spring_security.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        userRepository.findAll().forEach(usersList::add);
        return usersList;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        userRepository.findById(id).orElseThrow(RuntimeException::new);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
