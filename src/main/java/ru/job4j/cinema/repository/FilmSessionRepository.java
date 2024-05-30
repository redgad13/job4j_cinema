package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.model.Hall;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

public interface FilmSessionRepository {
    Collection<FilmSession> findAll();

    Optional<FilmSession> findById(int id);

    Optional<FilmSession> findByStartTime(LocalDateTime startTime);

    FilmSession save(FilmSession filmSession);

}
