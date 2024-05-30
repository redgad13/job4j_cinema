package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.model.FilmSession;

import java.util.Collection;
import java.util.Optional;

public interface FilmRepository {

    Optional<Film> findById(int id);

    Film add(Film film);

    boolean deleteById(int id);

    Collection<Film> findAll();

    Collection<FilmSession> findAllSessions(Film film);
}
