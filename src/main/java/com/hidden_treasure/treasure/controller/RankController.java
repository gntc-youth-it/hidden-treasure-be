package com.hidden_treasure.treasure.controller;

import com.hidden_treasure.treasure.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RankController {

    private final RankService rankService;

    @GetMapping("/rank/{teamNumber}")
    public ResponseEntity<?> getRank(@PathVariable Integer teamNumber) {
        return ResponseEntity.ok(rankService.getRank(teamNumber));
    }
}
