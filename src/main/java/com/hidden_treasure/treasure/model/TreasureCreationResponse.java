package com.hidden_treasure.treasure.model;

import com.hidden_treasure.treasure.domain.Treasure;
import lombok.Getter;

@Getter
public class TreasureCreationResponse {
    private final boolean succeed;

    public TreasureCreationResponse() {
        this.succeed = true;
    }
}
