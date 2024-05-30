package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository {
    Collection<User> findAll();

    Optional<User> findById(int id);
}