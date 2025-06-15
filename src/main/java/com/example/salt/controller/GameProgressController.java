package com.example.salt.controller;

import com.example.salt.dto.GameProgressDTO;
import com.example.salt.entity.MemberEntity;
import com.example.salt.repository.MemberRepository;
import com.example.salt.service.GameProgressService;
import com.example.salt.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class GameProgressController {

    private final GameProgressService gameProgressService;
    private final MemberService memberService;

    public GameProgressController(GameProgressService gameProgressService, MemberService memberService) {
        this.gameProgressService = gameProgressService;
        this.memberService = memberService;
    }

    @GetMapping("/init")
    public ResponseEntity<GameProgressDTO> getGameInitData(@RequestParam String username) {
        GameProgressDTO dto = gameProgressService.initMember(username);
        System.out.println(dto);
        System.out.println(username);
        return ResponseEntity.ok(dto);

    }

    @PostMapping("/next-day")
    public ResponseEntity<Void> incrementDay(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        if (username == null || username.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        gameProgressService.incrementDay(username);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset-progress")
    public ResponseEntity<Void> resetProgress(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        if (username == null || username.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        gameProgressService.resetProgress(username);

        return ResponseEntity.ok().build();
    }



}
