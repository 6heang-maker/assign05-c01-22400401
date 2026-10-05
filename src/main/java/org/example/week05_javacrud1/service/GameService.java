package org.example.week05_javacrud1.service;

import org.example.week05_javacrud1.domain.Game;
import org.example.week05_javacrud1.dto.*;
import org.example.week05_javacrud1.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class GameService {

    private final GameRepository repository;
    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public GameResponse create(GameRequest r) {
        return toResponse(
                repository.save(
                        new Game(
                                null,
                                r.title(),
                                r.genre(),
                                r.developer(),
                                r.price(),
                                r.rating()
                        )
                )
        );
    }

    public List<GameResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }
    public GameResponse findById(Long id) {
        return toResponse(findGame(id));
    }
    public GameResponse update(Long id, GameRequest r) {
        Game g = findGame(id);

        g.setTitle(r.title());
        g.setGenre(r.genre());
        g.setDeveloper(r.developer());
        g.setPrice(r.price());
        g.setRating(r.rating());

        return toResponse(repository.update(g));
    }

    public void delete(Long id) {
        findGame(id);
        repository.deleteById(id);
    }

    private Game findGame(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Game not found: " + id
                        )
                );
    }
    private GameResponse toResponse(Game g) {
        return new GameResponse(
                g.getId(),
                g.getTitle(),
                g.getGenre(),
                g.getDeveloper(),
                g.getPrice(),
                g.getRating()
        );
    }
}