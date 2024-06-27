package ru.job4j.cinema.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.service.FilmService;
import ru.job4j.cinema.service.FilmSessionService;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FilmSessionControllerTest {

    private FilmSessionService filmSessionService;
    private FilmSessionController filmSessionController;
    private FilmService filmService;

    @BeforeEach
    public void initServices() {
        filmService = mock(FilmService.class);
        filmSessionService = mock(FilmSessionService.class);
        filmSessionController = new FilmSessionController(filmSessionService, filmService);
    }

    @Test
    public void whenGetFilmSessionIsOk() {
        LocalDateTime start = LocalDateTime.of(2020, 4, 1, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 4, 1, 17, 0);
        var film1 = new Film(1, "Test1", "description", 2000, 1, 0, 120, 1);
        var film2 = new Film(2, "Test2", "description", 2000, 1, 0, 120, 1);
        var filmSession1 = new FilmSession(1, 1, 1, start, end, 1000);
        var filmSession2 = new FilmSession(2, 2, 1, start, end, 1000);
        var expectedFilms = List.of(film1, film2);
        var expectedSessions = List.of(filmSession1, filmSession2);
        when(filmService.findAll()).thenReturn(expectedFilms);
        var model = new ConcurrentModel();
        var view = filmSessionController.getFilmSession(model);
        var actualSessions = model.getAttribute("filmsession");
        assertThat(view).isEqualTo("filmsession/list");
        assertThat(actualSessions).isEqualTo(expectedSessions);
    }
}
