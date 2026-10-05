package org.example.week05_javacrud1.controller;

import org.example.week05_javacrud1.dto.*;
import org.example.week05_javacrud1.service.GameService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<GameResponse> create(@RequestBody GameRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(gameService.create(request));
    }

    @GetMapping
    public List<GameResponse> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public GameResponse findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @PutMapping("/{id}")
    public GameResponse update(
            @PathVariable Long id,
            @RequestBody GameRequest request) {

        return gameService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/genre/{genre}")
    public List<GameResponse> findByGenre(@PathVariable String genre) {
        return gameService.findByGenre(genre);
    }
}