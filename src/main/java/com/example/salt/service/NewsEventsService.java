package com.example.salt.service;

import com.example.salt.dto.NewsEventsDTO;
import com.example.salt.repository.NewsEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsEventsService {

    @Autowired
    private NewsEventsRepository repository;

    public NewsEventsService(NewsEventsRepository repository) {
        this.repository = repository;
    }

    public long getRowCount(){
        return repository.countRows();
    }

    public NewsEventsDTO selectById(int selectId) {
        return repository.findById(selectId)
                .map(NewsEventsDTO::new)
                .orElse(null);
    }
}
