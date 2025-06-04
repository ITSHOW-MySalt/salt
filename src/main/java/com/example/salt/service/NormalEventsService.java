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

@Service
public class NormalEventsService {

    @Autowired
    private NormalEventsRepository normalEventsRepository;


    public NormalEventsDTO selectById(int selectId) {
        return normalEventsRepository.findById(selectId)
                .map(NormalEventsDTO::new)
                .orElse(null);
    }
}
