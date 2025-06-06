package com.example.salt.service;

import com.example.salt.dto.StatChangeDTO;
import com.example.salt.entity.GameProgressEntity;
import com.example.salt.entity.NormalEventsEntity;
import com.example.salt.repository.GameProgressRepository;
import com.example.salt.repository.NormalEventsRepository;
import org.springframework.stereotype.Service;

@Service
public class StatChangeService {

    private final NormalEventsRepository normalEventsRepository;
    private final GameProgressRepository gameProgressRepository;

    public StatChangeService(NormalEventsRepository normalEventsRepository, GameProgressRepository gameProgressRepository) {
        this.normalEventsRepository = normalEventsRepository;
        this.gameProgressRepository = gameProgressRepository;
    }


    public StatChangeDTO applyChoice(int eventId, int choiceNumber){
        NormalEventsEntity normalEventsEntity = normalEventsRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("이벤트가 존재하지 않습니다."));

        return new StatChangeDTO(normalEventsEntity, choiceNumber);
    }
}
