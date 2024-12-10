package com.hidden_treasure.treasure.repository;

import com.hidden_treasure.treasure.domain.QRCode;
import com.hidden_treasure.treasure.domain.Treasure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreasureRepository extends JpaRepository<Treasure, Long> {
    Optional<Treasure> findByQrCode(QRCode code);
}
