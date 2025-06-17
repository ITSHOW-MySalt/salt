package com.example.salt.service;

import com.example.salt.dto.NewsEventsDTO;
import com.example.salt.entity.NewsProgressEntity;
import com.example.salt.repository.NewsEventsRepository;
import com.example.salt.repository.GameProgressNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsEventsService {

    private final NewsEventsRepository repository;
    private final GameProgressNewsRepository gameProgressNewsRepository;

    @Autowired
    public NewsEventsService(
            NewsEventsRepository repository,
            GameProgressNewsRepository gameProgressNewsRepository
    ) {
        this.repository = repository;
        this.gameProgressNewsRepository = gameProgressNewsRepository;
    }

    public List<NewsProgressEntity> getSavedNewsByUserId(int usernameId) {
        // usernameId가 곧 gameProgressId라고 가정하고 바로 조회
        return gameProgressNewsRepository.findByGameProgressId(usernameId);
    }

    public NewsEventsDTO selectById(int id) {
        return repository.findById(id)
                .map(NewsEventsDTO::new)
                .orElse(null);
    }

    @Transactional
    public void deleteNewsProgressByUserId(int usernameId, int newsId) {
        gameProgressNewsRepository.findByGameProgressId(usernameId).stream()
                .filter(n -> n.getNewsId() == newsId)
                .findFirst()
                .ifPresent(n -> gameProgressNewsRepository.deleteById(n.getId()));
    }
}