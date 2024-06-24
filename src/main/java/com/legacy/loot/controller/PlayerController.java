package com.legacy.loot.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legacy.loot.entity.Player;
import com.legacy.loot.service.PlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    
    @Autowired
    private PlayerService _playerService;

    @PostMapping("/save")
    public ResponseEntity<Player> SavePlayerData(@RequestBody Player player){
        try {
            return new ResponseEntity<Player>(_playerService.PlayerOutPut(player, HttpStatus.OK.toString(), "Player data saved successfully...."), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all/{name}")
    public CompletableFuture<Player> GetPlayerDataByName(@PathVariable String name){
        return _playerService.GetPlayerDataByName(name);
    }

}
