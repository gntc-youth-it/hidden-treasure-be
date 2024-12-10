package com.hidden_treasure.treasure.service;

import com.hidden_treasure.treasure.domain.Treasure;
import com.hidden_treasure.treasure.model.TreasureCreationResponse;
import com.hidden_treasure.treasure.model.TreasureImageResponse;
import com.hidden_treasure.treasure.repository.TreasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreasureService {

    private final TreasureRepository treasureRepository;

    public TreasureImageResponse getTreasure(Long id) {
        Treasure treasure = treasureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디에 해당하는 보물이 없습니다."));
        return new TreasureImageResponse(treasure);
    }

    public TreasureCreationResponse generateTreasure(int treasureCount) {
        List<Treasure> treasures = new ArrayList<>();
        for (int i = 0; i < treasureCount; i++) {
            treasures.add(Treasure.createTreasure());
        }
        treasureRepository.saveAll(treasures);
        return new TreasureCreationResponse();
    }
}
