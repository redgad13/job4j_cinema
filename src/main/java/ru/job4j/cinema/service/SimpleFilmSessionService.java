package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.repository.FilmSessionRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class SimpleFilmSessionService implements FilmSessionService {
    private final FilmSessionRepository filmSessionRepository;

    public SimpleFilmSessionService(FilmSessionRepository filmSessionRepository) {
        this.filmSessionRepository = filmSessionRepository;
    }

    @Override
    public Collection<FilmSession> findAll() {
        return filmSessionRepository.findAll();
    }

    @Override
    public Optional<FilmSession> findById(int id) {
        return filmSessionRepository.findById(id);
    }

    @Override
    public Optional<FilmSession> findByStartTime(LocalDateTime startTime) {
        return filmSessionRepository.findByStartTime(startTime);
    }

    @Override
    public FilmSession save(FilmSession filmSession) {
        return filmSessionRepository.save(filmSession);
    }
}
