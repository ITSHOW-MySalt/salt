package com.example.salt.controller;

import com.example.salt.entity.HeroinProgressEntity;
import com.example.salt.service.HeroinProgressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heroin")
@CrossOrigin(origins = "http://localhost:3000")
public class HeroinProgressController {

    private final HeroinProgressService heroinService;

    public HeroinProgressController(HeroinProgressService heroinService) {
        this.heroinService = heroinService;
    }

    // [1] 특정 게임 진행 ID에 대한 상태 조회
    @GetMapping("/{gameProgressId}")
    public HeroinProgressEntity getHeroinProgress(@PathVariable int gameProgressId) {
        return heroinService.getByGameProgressId(gameProgressId)
                .orElseThrow(() -> new IllegalArgumentException("해당 진행 없음"));
    }

    // [2] 만남 횟수 +1
    @PostMapping("/{gameProgressId}/meet")
    public HeroinProgressEntity meetHeroin(
            @PathVariable int gameProgressId,
            @RequestParam String target // A 또는 B
    ) {
        return heroinService.incrementMeetCount(gameProgressId, target);
    }

    // [3] 호감도 +X
    @PostMapping("/{gameProgressId}/affection")
    public HeroinProgressEntity increaseAffection(
            @PathVariable int gameProgressId,
            @RequestParam String target, // A 또는 B
            @RequestParam int amount
    ) {
        return heroinService.increaseAffection(gameProgressId, target, amount);
    }

    // [4] 진행 초기화 (없으면 생성)
    @PostMapping("/init-progress")
    public ResponseEntity<?> initHeroineProgress(@RequestParam int gameProgressId) {
        boolean created = heroinService.initProgressIfNotExist(gameProgressId);
        if (created) {
            return ResponseEntity.ok("초기화 완료");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재함");
        }
    }
}
