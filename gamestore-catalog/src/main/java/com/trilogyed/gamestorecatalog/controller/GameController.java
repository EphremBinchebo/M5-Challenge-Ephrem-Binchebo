package com.trilogyed.gamestorecatalog.controller;

import com.trilogyed.gamestorecatalog.service.GameStoreServiceLayer;
import com.trilogyed.gamestorecatalog.viewModel.ConsoleViewModel;
import com.trilogyed.gamestorecatalog.viewModel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/game")
@CrossOrigin(origins = {"http://localhost:3000"})
@RefreshScope
public class GameController {

    @Autowired
    GameStoreServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel gameViewModel) {
        gameViewModel = service.createGame(gameViewModel);
        return gameViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") long gameId) {
        GameViewModel gameViewModel = service.getGameById(gameId);
        if (gameViewModel == null) {
            throw new IllegalArgumentException("Console could not be retrieved for id " + gameId);
        } else {
            return gameViewModel;
        }
    }


    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid GameViewModel gameViewModel) {
        service.updateGame(gameViewModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int gameId) {
        service.deleteGame(gameId);
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable String title) {
        List<GameViewModel> gamesByTitle = service.getGameByTitle(title);

        if (gamesByTitle == null || gamesByTitle.isEmpty()) {
            throw new IllegalArgumentException("No games were found with " + title);
        } else {
            return gamesByTitle;
        }
    }
//
//    @GetMapping("/{esrb}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<GameViewModel> getGamesByEsrbRating(@PathVariable("esrb") String esrb) {
//        List<GameViewModel> gamesByEsrbRating = service.getGameByEsrb(esrb);
//
//        if (gamesByEsrbRating == null || gamesByEsrbRating.isEmpty()) {
//            throw new IllegalArgumentException("No games were found with ESRB Rating " + esrb);
//        } else {
//            return gamesByEsrbRating;
//        }
//    }

//    @GetMapping("/{studio}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio) {
//        List<GameViewModel> gamesByStudio = service.getGameByStudio(studio);
//
//        if (gamesByStudio == null || gamesByStudio.isEmpty()) {
//            throw new IllegalArgumentException("No games were found from " + studio);
//        } else {
//            return gamesByStudio;
//        }
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        List<GameViewModel> games = service.getAllGames();

        if (games == null || games.isEmpty()) {
            throw new IllegalArgumentException("No games were found.");
        } else {
            return games;
        }
    }
}