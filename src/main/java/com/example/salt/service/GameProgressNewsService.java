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
        newsIds.forEach(newsId -> {
            NewsProgressEntity entity = new NewsProgressEntity();
            entity.setGameProgressId(gameProgressId);  // 숫자로 직접 설정
            entity.setNewsId(newsId);
            gameProgressNewsRepository.save(entity);
        });
    }

    public List<NewsProgressEntity> getSavedNews(int gameProgressId) {
        return gameProgressNewsRepository.findByGameProgressId(gameProgressId);
    }

    @Transactional
    public void deleteAllByGameProgressId(int gameProgressId) {
        gameProgressNewsRepository.deleteByGameProgressId(gameProgressId);
    }

    @Transactional
    public void deleteById(int id) {
        gameProgressNewsRepository.deleteById(id);
    }
}
