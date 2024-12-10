package com.hidden_treasure.treasure.repository;

import com.hidden_treasure.treasure.domain.QRCode;
import com.hidden_treasure.treasure.domain.Treasure;
import com.hidden_treasure.treasure.model.TeamTreasureStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TreasureRepository extends JpaRepository<Treasure, Long> {
    Optional<Treasure> findByQrCode(QRCode code);

    @Query(value = """
            SELECT team_number as teamNumber,
                   COUNT(treasure_id) as treasureCount,
                   RANK() OVER (ORDER BY COUNT(treasure_id) DESC) as `rank`
            FROM treasure_scans
            GROUP BY team_number
            """, nativeQuery = true)
    List<TeamTreasureStats> findTeamTreasureStats();

    @Query(value = """
            SELECT 
                t.team_number as teamNumber,
                t.treasure_count as treasureCount,
                (SELECT COUNT(*) + 1 
                 FROM (
                     SELECT team_number, COUNT(*) as cnt 
                     FROM treasure_scans 
                     GROUP BY team_number
                     HAVING COUNT(*) > t.treasure_count
                 ) r
                ) as `rank`
            FROM (
                SELECT team_number, COUNT(*) as treasure_count
                FROM treasure_scans
                GROUP BY team_number
            ) t
            WHERE t.team_number = :teamNumber
            """, nativeQuery = true)
    Optional<TeamTreasureStats> findStatsByTeamNumber(@Param("teamNumber") int teamNumber);
}
