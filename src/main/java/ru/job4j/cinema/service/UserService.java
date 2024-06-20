package ru.job4j.cinema.service;

import ru.job4j.cinema.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    Collection<User> findAll();

    Optional<User> findById(int id);

    Optional<User> findByEmailAndPassword(String email, String password);

    boolean save(User user);
}
