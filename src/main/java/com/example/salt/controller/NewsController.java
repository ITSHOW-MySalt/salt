package com.example.salt.controller;

import com.example.salt.dto.NewsDTO;
import com.example.salt.entity.NewsEntity;
import com.example.salt.entity.NewsProgressEntity;
import com.example.salt.service.GameProgressNewsService;
import com.example.salt.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private GameProgressNewsService gameProgressNewsService;

    // 1. 랜덤 3개 id 뽑아서 저장
    @PostMapping("/random-ids")
    public ResponseEntity<?> saveRandomNewsIds(@RequestParam int gameProgressId) {
        // 기존 뉴스 삭제
        gameProgressNewsService.deleteAllByGameProgressId(gameProgressId);

        // 새로 저장
        List<Integer> randomIds = newsService.getRandomNewsIds(3);
        gameProgressNewsService.saveRandomNewsIds(gameProgressId, randomIds);

        return ResponseEntity.ok(randomIds);
    }


    // 2. 저장된 3개 중 하나 랜덤 반환 + 삭제
    @GetMapping("/random-one")
    public ResponseEntity<?> getRandomNewsAndRemove(@RequestParam int gameProgressId) {
        List<NewsProgressEntity> savedNews = gameProgressNewsService.getSavedNews(gameProgressId);
        if (savedNews.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // 랜덤으로 하나 선택
        NewsProgressEntity selected = savedNews.get(new Random().nextInt(savedNews.size()));

        NewsEntity news = newsService.getNewsById(selected.getNewsId());

        // 선택된 건 삭제
        gameProgressNewsService.deleteById(selected.getId());

        if (news == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(news);
    }

    @GetMapping("/saved-news")
    public ResponseEntity<?> getSavedNews(@RequestParam int gameProgressId) {
        List<NewsProgressEntity> savedNewsEntities = gameProgressNewsService.getSavedNews(gameProgressId);
        if (savedNewsEntities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<NewsEntity> newsList = new ArrayList<>();
        for (NewsProgressEntity npe : savedNewsEntities) {
            NewsEntity news = newsService.getNewsById(npe.getNewsId());
            if (news != null) {
                newsList.add(news);
            }
        }
        return ResponseEntity.ok(newsList);
    }

}
