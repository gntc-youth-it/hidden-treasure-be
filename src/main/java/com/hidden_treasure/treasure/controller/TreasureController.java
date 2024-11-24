package com.hidden_treasure.treasure.controller;

import com.hidden_treasure.treasure.service.TreasureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TreasureController {

    private final TreasureService treasureService;

    @GetMapping("/treasure/{treasureId}")
    public ResponseEntity<?> getTreasure(@PathVariable Long treasureId) {
        return ResponseEntity.ok(treasureService.getTreasure(treasureId));
    }

    @PostMapping("/treasure")
    public ResponseEntity<?> generateTreasure() {
        return ResponseEntity.ok(treasureService.generateTreasure());
    }
}
