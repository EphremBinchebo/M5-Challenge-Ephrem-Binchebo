package com.trilogyed.gamestoreinvoicing.controller;

import com.trilogyed.gamestoreinvoicing.model.ConsoleViewModel;
import com.trilogyed.gamestoreinvoicing.model.GameViewModel;
import com.trilogyed.gamestoreinvoicing.model.TShirtViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@FeignClient(name = "gamestore-catalog")
public interface GameStoreCatalogClient {

    @GetMapping("/console/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable long id);
    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") long gameId);

    @GetMapping("tshirt/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable long id);
    @PutMapping("/console")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel);

    @PutMapping("/game")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid GameViewModel gameViewModel);

    @PutMapping("/tshirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel);

    @PostMapping("/tshirt")
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel createTShirt(TShirtViewModel tShirtViewModel);

}
