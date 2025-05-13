package com.example.salt.service;

import com.example.salt.dto.NormalEventsDTO;
import com.example.salt.repository.NormalEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NormalEventsService {

    @Autowired
    private NormalEventsRepository repository;

    public NormalEventsDTO selectById(int selectId) {
        return repository.findById(selectId)
                .map(NormalEventsDTO::new)
                .orElse(null);
    }
}
