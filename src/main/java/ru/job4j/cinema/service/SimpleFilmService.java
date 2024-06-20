package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FileDto;
import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.repository.FilmRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class SimpleFilmService implements FilmService {
    private final FilmRepository filmRepository;
    private final FileService fileService;

    public SimpleFilmService(FilmRepository filmRepository, FileService fileService) {
        this.filmRepository = filmRepository;
        this.fileService = fileService;
    }

    @Override
    public Film save(Film film, FileDto image) {
        saveNewFile(film, image);
        return filmRepository.add(film);
    }

    private void saveNewFile(Film film, FileDto image) {
        var file = fileService.save(image);
        film.setFileId(file.getId());
    }

    @Override
    public boolean deleteById(int id) {
        return filmRepository.deleteById(id);
    }

    @Override
    public Optional<Film> findById(int id) {
        return filmRepository.findById(id);
    }

    @Override
    public Collection<Film> findAll() {
        return filmRepository.findAll();
    }
}
