package com.hidden_treasure.treasure.repository;

import com.hidden_treasure.treasure.domain.Treasure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreasureRepository extends JpaRepository<Treasure, Long> {

}
