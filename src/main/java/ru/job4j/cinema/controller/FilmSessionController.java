package ru.job4j.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cinema.service.FilmService;
import ru.job4j.cinema.service.FilmSessionService;

@Controller
@RequestMapping("/filmsession")
public class FilmSessionController {

    private final FilmSessionService filmSessionService;
    private final FilmService filmService;

    public FilmSessionController(FilmSessionService filmSessionService, FilmService filmService) {
        this.filmSessionService = filmSessionService;
        this.filmService = filmService;
    }

    @GetMapping()
    public String getFilmSession(Model model) {
        model.addAttribute("filmsession", filmSessionService.findAll());
        model.addAttribute("films", filmService.findAll());
        return "filmsession/list";
    }
}
