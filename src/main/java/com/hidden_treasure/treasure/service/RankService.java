package com.hidden_treasure.treasure.service;

import com.hidden_treasure.common.exception.EntityNotFoundException;
import com.hidden_treasure.treasure.model.TeamTreasureStats;
import com.hidden_treasure.treasure.repository.TreasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.hidden_treasure.common.exception.model.ExceptionCode.TEAM_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class RankService {

    private final TreasureRepository repository;

    @Transactional(readOnly = true)
    public TeamTreasureStats getRank(Integer teamNumber) {
        return repository.findStatsByTeamNumber(teamNumber)
                .orElseThrow(() -> new EntityNotFoundException(TEAM_NOT_FOUND));
    }
}
