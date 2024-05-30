package ru.job4j.cinema.service;

import ru.job4j.cinema.dto.FileDto;
import ru.job4j.cinema.model.Film;

import java.util.Collection;
import java.util.Optional;

public interface FilmService {
    Film save(Film film, FileDto image);

    boolean deleteById(int id);

    Optional<Film> findById(int id);

    Collection<Film> findAll();
}
