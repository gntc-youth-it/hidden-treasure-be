package com.hidden_treasure.treasure.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreasureScan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int teamNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treasure_id")
    private Treasure treasure;

    private LocalDateTime scannedAt;

    public TreasureScan(int teamNumber, Treasure treasure) {
        this.teamNumber = teamNumber;
        this.treasure = treasure;
        this.scannedAt = LocalDateTime.now();
    }
}
