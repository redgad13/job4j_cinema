package ru.job4j.cinema.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.cinema.model.Hall;

import java.util.Optional;

@Repository
public class Sql2oHallRepository implements HallRepository {
    private final Sql2o sql2o;

    public Sql2oHallRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Hall> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM halls WHERE id = :id");
            query.addParameter("id", id);
            var hall = query.executeAndFetchFirst(Hall.class);
            return Optional.ofNullable(hall);
        }
    }

    @Override
    public Hall save(Hall hall) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("INSERT INTO halls (name, row_count, place_count) VALUES (:name, :row_count, :place_count)", true);
            query.addParameter("name", hall.getName())
                    .addParameter("row_count", hall.getRowCount())
                    .addParameter("place_count", hall.getPlaceCount());
            int generatedKeys = query.executeUpdate().getKey(Integer.class);
            hall.setId(generatedKeys);
            return hall;
        }
    }

    @Override
    public void deleteById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("DELETE FROM halls WHERE id = :id");
            query.addParameter("id", id);
            query.executeUpdate();
        }
    }
}
