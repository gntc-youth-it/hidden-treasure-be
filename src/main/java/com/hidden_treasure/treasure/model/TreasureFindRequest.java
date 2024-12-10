package com.hidden_treasure.treasure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TreasureFindRequest {
    private String treasureCode;
    private Integer teamNumber;
}
