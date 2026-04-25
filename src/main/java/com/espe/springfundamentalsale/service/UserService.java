package com.espe.springfundamentalsale.service;

import com.espe.springfundamentalsale.exception.UserNotFoundException;
import com.espe.springfundamentalsale.model.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users = Arrays.asList(
            new User(1L, "Alexandra Tana", "ale@espe.edu.ec"),
            new User(2L, "John Doe", "john@espe.edu.ec"),
            new User(3L, "Jane Smith", "jane@espe.edu.ec")
    );

    public List<User> findAll() {
        return users;
    }

    public User findById(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found with id: " + id));
    }
}