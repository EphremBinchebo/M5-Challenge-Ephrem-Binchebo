package com.trilogyed.gamestoreinvoicing.controller;


import com.trilogyed.gamestoreinvoicing.model.ConsoleViewModel;
import com.trilogyed.gamestoreinvoicing.model.GameViewModel;
import com.trilogyed.gamestoreinvoicing.model.TShirtViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@FeignClient(name="gamestore-catalog")
public interface GameStoreCatalogClient {

    @GetMapping("/console/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ConsoleViewModel> getConsole(@PathVariable long id);

    @GetMapping("tshirt/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<TShirtViewModel> getTShirt(@PathVariable long id);

    @PostMapping("/console")
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel);
        @PutMapping("/console")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel);


            @GetMapping("/console/manufacturer/{manufacturer}")
            @ResponseStatus(HttpStatus.OK)
            public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manu);
                @GetMapping("console")
                @ResponseStatus(HttpStatus.OK)
                public List<ConsoleViewModel> getAllConsoles();

    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel gameViewModel);

    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") long gameId);

    @PutMapping("/game")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid GameViewModel gameViewModel);

    @DeleteMapping("game//{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int gameId);

    @GetMapping("/game/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable String title);

    @GetMapping("/game/esrbrating/{esrb}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByEsrbRating(@PathVariable("esrb") String esrb);

    @GetMapping("/game/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio);

    @GetMapping("/game")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames();

    @PostMapping("/tshirt")
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel createTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel);

    @PutMapping("/tshirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel);

    @DeleteMapping("/tshirt/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("id") int tShirtId);

    @GetMapping("/tshirt/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsBySize(@PathVariable("size") String size);

    @GetMapping("/tshirt/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsByColor(@PathVariable("color") String color);

    @GetMapping("/tshirt")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getAllTShirts();

    }
