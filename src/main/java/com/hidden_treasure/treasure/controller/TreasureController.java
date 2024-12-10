package com.hidden_treasure.treasure.controller;

import com.hidden_treasure.treasure.model.TreasureFindRequest;
import com.hidden_treasure.treasure.service.TreasureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TreasureController {

    private final TreasureService treasureService;

    @GetMapping("/treasure/{treasureId}")
    public ResponseEntity<?> getTreasure(@PathVariable Long treasureId) {
        return ResponseEntity.ok(treasureService.getTreasure(treasureId));
    }

    @PostMapping("/treasure")
    public ResponseEntity<?> generateTreasure(@RequestParam Integer treasureCount) {
        return ResponseEntity.ok(treasureService.generateTreasure(treasureCount));
    }

    @PostMapping("/treasure/find")
    public ResponseEntity<?> findTreasure(@RequestBody TreasureFindRequest request) {
        return ResponseEntity.ok(treasureService.find(request));
    }
}
