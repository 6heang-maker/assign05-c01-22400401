package org.example.week05_javacrud1.repository;

import org.example.week05_javacrud1.domain.Game;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemoryGameRepository implements GameRepository {

    private final Map<Long, Game> store = new LinkedHashMap<>();
    private long sequence = 0L;
    @Override
    public Game save(Game game) {
        game.setId(++sequence);
        store.put(game.getId(), game);
        return game;
    }

    @Override
    public List<Game> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Game> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Game update(Game game) {
        store.put(game.getId(), game);
        return game;
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}