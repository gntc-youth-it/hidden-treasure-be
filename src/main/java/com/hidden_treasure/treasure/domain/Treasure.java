package com.hidden_treasure.treasure.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Treasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private QRCode qrCode;

    @ElementCollection
    @CollectionTable(name = "treasure_scans", joinColumns = @JoinColumn(name = "treasure_id"))
    @Column(name = "team_number")
    private Set<Integer> scannedTeams = new HashSet<>();

    public boolean isAlreadyScannedByTeam(int teamNumber) {
        return scannedTeams.contains(teamNumber);
    }

    public void addScannedTeam(int teamNumber) {
        if (!scannedTeams.add(teamNumber)) {
            throw new IllegalArgumentException("This team has already scanned this treasure.");
        }
    }
}
