package org.example.week05_javacrud1.repository;

import org.example.week05_javacrud1.domain.Game;
import java.util.List;
import java.util.Optional;

public interface GameRepository {
    Game save(Game game);
    List<Game> findAll();
    Optional<Game> findById(Long id);
    Game update(Game game);
    void deleteById(Long id);
}