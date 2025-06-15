package com.example.salt.service;

import com.example.salt.entity.GameProgressEntity;
import com.example.salt.entity.NewsProgressEntity;
import com.example.salt.repository.GameProgressNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameProgressNewsService {

    @Autowired
    private GameProgressNewsRepository gameProgressNewsRepository;

    @Transactional
    public void saveRandomNewsIds(int gameProgressId, List<Integer> newsIds) {
        GameProgressEntity progressEntity = new GameProgressEntity();
        progressEntity.setId(gameProgressId); // 껍데기만 생성해도 JPA에서는 FK 설정 가능

        newsIds.forEach(id -> {
            NewsProgressEntity entity = new NewsProgressEntity();
            entity.setGameProgressEntity(progressEntity); // 이게 핵심!
            entity.setNewsId(id);
            gameProgressNewsRepository.save(entity);
        });
    }

    public List<NewsProgressEntity> getSavedNews(int gameProgressId) {
        return gameProgressNewsRepository.findByGameProgressEntity_Id(gameProgressId);
    }


    @Transactional
    public void deleteById(int id) {
        gameProgressNewsRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllByGameProgressId(int gameProgressId) {
        gameProgressNewsRepository.deleteByGameProgressEntityId(gameProgressId);
    }

}
