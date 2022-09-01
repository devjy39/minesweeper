package com.zerobase.minesweeper.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zerobase.minesweeper.dto.GameRequest;
import com.zerobase.minesweeper.dto.GameResponse;
import com.zerobase.minesweeper.dto.GetGameListResponse;
import com.zerobase.minesweeper.dto.GetGameResponse;
import com.zerobase.minesweeper.service.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;
    
    @PostMapping(value = "game", produces = "application/json")
    public GameResponse newGame(@RequestBody @Valid GameRequest request) {
        return gameService.registerGame(request);
    }

    @GetMapping(value = "game/{gameId}", produces = "application/json")
    public GetGameResponse getGame(@PathVariable String gameId) {
        return gameService.getGame(gameId);
    }


    @GetMapping(value = "game/list/{gamerId}", produces = "application/json")
    public GetGameListResponse getGameList(@PathVariable String gamerId) {
        return gameService.getGameList(gamerId);
    }
}
