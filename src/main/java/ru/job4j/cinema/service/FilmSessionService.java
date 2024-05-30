package ru.job4j.cinema.service;

import ru.job4j.cinema.model.FilmSession;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

public interface FilmSessionService {
    Collection<FilmSession> findAll();

    Optional<FilmSession> findById(int id);

    Optional<FilmSession> findByStartTime(LocalDateTime startTime);

    FilmSession save(FilmSession filmSession);
}
