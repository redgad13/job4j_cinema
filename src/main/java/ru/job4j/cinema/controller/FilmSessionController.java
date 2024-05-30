package ru.job4j.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cinema.repository.FilmSessionRepository;

@Controller
@RequestMapping("filmsession")
public class FilmSessionController {

    private final FilmSessionRepository filmSessionRepository;

    public FilmSessionController(FilmSessionRepository filmSessionRepository) {
        this.filmSessionRepository = filmSessionRepository;
    }

    @GetMapping()
    public String getFilmSession(Model model) {
        model.addAttribute("filmsession", filmSessionRepository.findAll());
        return "filmsession/list";
    }
}
