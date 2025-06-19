package com.example.salt.controller;

import com.example.salt.dto.EndingDTO;
import com.example.salt.dto.GameProgressDTO;
import com.example.salt.service.EndingService;
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
    private final EndingService endingService;

    public GameProgressController(GameProgressService gameProgressService, MemberService memberService, EndingService endingService) {
        this.gameProgressService = gameProgressService;
        this.memberService = memberService;
        this.endingService = endingService;
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

    @PostMapping("/update-progress")
    public ResponseEntity<?> updateProgress(@RequestBody Map<String, Object> request) {
        String username = (String) request.get("username");
        if (username == null || username.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Integer money = (Integer) request.get("ch_stat_money");
            Integer health = (Integer) request.get("ch_stat_health");
            Integer mental = (Integer) request.get("ch_stat_mental");
            Integer rep = (Integer) request.get("ch_stat_rep");

            gameProgressService.updateProgress(username, money, health, mental, rep);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/check-ending")
    public ResponseEntity<?> checkEnding(@RequestParam String username) {
        if (username == null || username.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            EndingDTO endingDTO = endingService.checkEnding(username);
            if (endingDTO != null) {
                gameProgressService.updateEndingList(username, 1);

                return ResponseEntity.ok(Map.of(
                        "ending", endingDTO.getEndingname(),
                        "imglink", endingDTO.getImglink()
                ));
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
