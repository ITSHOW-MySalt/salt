package com.example.salt.service;

import com.example.salt.dto.NormalEventsDTO;
import com.example.salt.entity.NormalEventsEntity;
import com.example.salt.repository.NormalEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Service
public class NormalEventsService {

    @Autowired
    private NormalEventsRepository normalEventsRepository;

    // ID로 이벤트 선택
    public NormalEventsDTO selectById(int selectId) {
        return normalEventsRepository.findById(selectId)
                .map(NormalEventsDTO::new)
                .orElse(null);
    }

    // 전체 이벤트 목록에서 랜덤으로 하나 선택
    public NormalEventsDTO randomEvent() {
        List<NormalEventsEntity> allEvents = normalEventsRepository.findAllByOrderById();

        if (allEvents.isEmpty()) {
            return null;
        }

        // 랜덤 인덱스 선택
        int randomIndex = new Random().nextInt(allEvents.size());
        NormalEventsEntity randomEvent = allEvents.get(randomIndex);

        // Entity → DTO 변환
        return new NormalEventsDTO(randomEvent);
    }
}
