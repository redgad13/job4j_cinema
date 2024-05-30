package ru.job4j.cinema.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.model.Hall;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Repository
public class Sql2oFilmSessionRepository implements FilmSessionRepository {
    private final Sql2o sql2o;

    public Sql2oFilmSessionRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Collection<FilmSession> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM film_sessions");
            return query.setColumnMappings(FilmSession.COLUMN_MAPPING).executeAndFetch(FilmSession.class);
        }
    }

    @Override
    public Optional<FilmSession> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM film_sessions WHERE id = :id");
            query.addParameter("id", id);
            var filmSession = query.executeAndFetchFirst(FilmSession.class);
            return Optional.ofNullable(filmSession);
        }
    }

    @Override
    public Optional<FilmSession> findByStartTime(LocalDateTime startTime) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM film_sessions WHERE start_time = :start_time");
            query.addParameter("start_time", startTime);
            var filmSession = query.executeAndFetchFirst(FilmSession.class);
            return Optional.ofNullable(filmSession);
        }
    }

    @Override
    public FilmSession save(FilmSession filmSession) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("INSERT INTO film_sessions "
                    + "(film_id, halls_id, start_time, end_time, price) VALUES "
                    + "(:film_id, :halls_id, :start_time, :end_time, :price)");
            query.addParameter("film_id", filmSession.getFilmId())
                    .addParameter("halls_id", filmSession.getHallId())
                    .addParameter("start_time", filmSession.getStartTime())
                    .addParameter("end_time", filmSession.getEndTime())
                    .addParameter("price", filmSession.getPrice());
            int generatedKey = query.executeUpdate().getKey(Integer.class);
            filmSession.setId(generatedKey);
            return filmSession;
        }
    }
}
