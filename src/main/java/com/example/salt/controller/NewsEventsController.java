package com.example.salt.controller;

import com.example.salt.dto.NewsEventsDTO;
import com.example.salt.entity.NewsProgressEntity;
import com.example.salt.service.NewsEventsService;
import com.example.salt.service.GameProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class NewsEventsController {

    private final NewsEventsService service;
    private final GameProgressService gameProgressService; // ✅ GameProgressService 주입

    public NewsEventsController(NewsEventsService service, GameProgressService gameProgressService) {
        this.service = service;
        this.gameProgressService = gameProgressService;
    }

    @GetMapping("/events/news")
    public ResponseEntity<?> getNewsEvent(@RequestParam("username_id") int userId) {
        // userId 기준 뉴스 목록 조회
        List<NewsProgressEntity> newsList = service.getSavedNewsByUserId(userId);
        if (newsList.isEmpty()) {
            return ResponseEntity.status(404).body("저장된 뉴스가 없습니다.");
        }

        int randomIndex = new Random().nextInt(newsList.size());
        NewsProgressEntity selected = newsList.get(randomIndex);

        int newsId = selected.getNewsId();

        NewsEventsDTO dto = service.selectById(newsId);

        // userId 기준 뉴스 삭제
        service.deleteNewsProgressByUserId(userId, newsId);

        return ResponseEntity.ok(dto);
    }


}
