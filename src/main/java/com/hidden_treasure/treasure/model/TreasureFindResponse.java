package com.hidden_treasure.treasure.model;

import lombok.Getter;

@Getter
public class TreasureFindResponse {
    private final boolean succeed;

    public TreasureFindResponse() {
        this.succeed = true;
    }
}
