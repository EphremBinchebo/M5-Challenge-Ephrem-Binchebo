package com.trilogyed.gamestoreinvoicing.controller;


import com.trilogyed.gamestoreinvoicing.model.ConsoleViewModel;
import com.trilogyed.gamestoreinvoicing.model.GameViewModel;
import com.trilogyed.gamestoreinvoicing.model.TShirtViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@FeignClient(name="gamestore-catalog")
public interface GameStoreCatalogClient {
    @GetMapping("/console/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ConsoleViewModel> getConsole(@PathVariable long id);

    @GetMapping("game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<GameViewModel> getGameInfo(@PathVariable long id);

    @GetMapping("tshirt/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<TShirtViewModel> getTShirt(@PathVariable long id);

    @GetMapping("/console")
    public ResponseEntity<List<ConsoleViewModel>> getAllConsoles();
}
