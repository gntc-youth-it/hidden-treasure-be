package com.hidden_treasure.treasure.model;

import com.google.zxing.WriterException;
import com.hidden_treasure.treasure.domain.Treasure;
import java.io.IOException;
import lombok.Getter;

@Getter
public class TreasureImageResponse {
    private final Long id;

    private final String image;

    public TreasureImageResponse(final Treasure treasure) {
        this.id = treasure.getId();
        this.image = treasure.getQRImage();
    }
}
