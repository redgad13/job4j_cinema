package ru.job4j.cinema.service;

import ru.job4j.cinema.model.Hall;

import java.util.Optional;

public interface HallService {
    Optional<Hall> findById(int id);

    Hall save(Hall hall);

    void deleteById(int id);
}
