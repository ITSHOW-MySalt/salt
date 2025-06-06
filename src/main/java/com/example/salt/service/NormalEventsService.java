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


    public NormalEventsDTO selectById(int selectId) {
        return normalEventsRepository.findById(selectId)
                .map(NormalEventsDTO::new)
                .orElse(null);
    }

    // 이벤트 번호 랜덤으로 받아오기
    public NormalEventsDTO randomEvent() {
        List<NormalEventsEntity> allEvents = normalEventsRepository.findAllByOrderById();

        if(allEvents.isEmpty()){
            return null;
        }

        int randomIndex = (int)(Math.random()*allEvents.size());
        NormalEventsEntity randomEvent = allEvents.get(randomIndex);

        return new NormalEventsDTO(randomEvent);
    }
}
