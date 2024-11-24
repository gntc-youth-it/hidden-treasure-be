package com.hidden_treasure.treasure.model;

import com.hidden_treasure.treasure.domain.Treasure;
import lombok.Getter;

@Getter
public class TreasureCreationResponse {
    private final Long id;

    public TreasureCreationResponse(final Treasure treasure) {
        this.id = treasure.getId();
    }
}
