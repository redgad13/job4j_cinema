package ru.job4j.cinema.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import ru.job4j.cinema.model.User;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class Sql2oUserRepository implements UserRepository {
    private static final Logger LOGGER = Logger.getLogger(Sql2oUserRepository.class.getName());

    private final Sql2o sql2o;

    public Sql2oUserRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Collection<User> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM users");
            return query.executeAndFetch(User.class);
        }
    }

    @Override
    public Optional<User> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM users WHERE id = :id");
            query.addParameter("id", id);
            var user = query.executeAndFetchFirst(User.class);
            return Optional.ofNullable(user);
        }
    }

    @Override
    public Optional<User> save(User user) {
        Optional<User> rsl = Optional.empty();
        try (var connection = sql2o.open()) {
            var sql = """
                    INSERT INTO users (full_name, email, password)
                    VALUES (:full_name, :email, :password)
                    """;
            var query = connection.createQuery(sql, true)
                    .addParameter("full_name", user.getFullName())
                    .addParameter("email", user.getEmail())
                    .addParameter("password", user.getPassword());
            int generatedId = query.executeUpdate().getKey(Integer.class);
            user.setId(generatedId);
            rsl = Optional.of(user);
        } catch (Sql2oException e) {
            LOGGER.log(Level.ALL, "Exception occurred");
        }
        return rsl;
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        try (var connection = sql2o.open()) {
            var sql = "SELECT * FROM users WHERE email = :email AND password = :password";
            var query = connection.createQuery(sql);
            query.addParameter("email", email)
                    .addParameter("password", password);
            var user = query.setColumnMappings(User.COLUMN_MAPPING).executeAndFetchFirst(User.class);
            return Optional.ofNullable(user);
        }
    }
}
