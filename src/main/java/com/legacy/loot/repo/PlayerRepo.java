package com.legacy.loot.repo;

import java.util.concurrent.CompletableFuture;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.legacy.loot.entity.Player;

public interface PlayerRepo extends MongoRepository<Player, String> {
    @Query("{'name' : ?0}")
    CompletableFuture<Player> FindPlayerByName(String name);
}
