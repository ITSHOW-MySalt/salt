package com.example.salt.controller;

import com.example.salt.dto.NewsDTO;
import com.example.salt.dto.NewsProgressDTO;
import com.example.salt.entity.NewsEntity;
import com.example.salt.entity.NewsProgressEntity;
import com.example.salt.service.GameProgressNewsService;
import com.example.salt.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private GameProgressNewsService gameProgressNewsService;

    // 1. 랜덤 3개 뉴스 ID 뽑아서 저장
    @PostMapping("/random-ids")
    public ResponseEntity<List<Integer>> saveRandomNewsIds(@RequestParam int gameProgressId) {
        gameProgressNewsService.deleteAllByGameProgressId(gameProgressId);

        List<Integer> randomIds = newsService.getRandomNewsIds(3);
        gameProgressNewsService.saveRandomNewsIds(gameProgressId, randomIds);

        return ResponseEntity.ok(randomIds);
    }

    // 2. 저장된 뉴스 중 랜덤 1개 반환하고 삭제
    @GetMapping("/random-one")
    public ResponseEntity<NewsDTO> getRandomNewsAndRemove(@RequestParam int gameProgressId) {
        List<NewsProgressEntity> savedNews = gameProgressNewsService.getSavedNews(gameProgressId);
        if (savedNews.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        NewsProgressEntity selected = savedNews.get(new Random().nextInt(savedNews.size()));
        NewsEntity news = newsService.getNewsById(selected.getNewsId());
        gameProgressNewsService.deleteAllByGameProgressId(selected.getId());

        if (news == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new NewsDTO(news));
    }

    // 3. 저장된 뉴스 목록 전체 반환
    @GetMapping("/saved-news")
    public ResponseEntity<List<NewsDTO>> getSavedNews(@RequestParam int gameProgressId) {
        List<NewsProgressEntity> savedNewsEntities = gameProgressNewsService.getSavedNews(gameProgressId);
        if (savedNewsEntities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<NewsDTO> newsList = savedNewsEntities.stream()
                .map(n -> newsService.getNewsById(n.getNewsId()))
                .filter(n -> n != null)
                .map(NewsDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(newsList);
    }
}
