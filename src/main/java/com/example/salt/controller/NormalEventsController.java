package com.example.salt.controller;

import com.example.salt.dto.NormalEventsDTO;
import com.example.salt.dto.StatChangeDTO;
import com.example.salt.service.NormalEventsService;
import com.example.salt.service.StatChangeService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class NormalEventsController {

    private final NormalEventsService normalEventsService;
    private final StatChangeService statChangeService;

    // 생성자 주입
    public NormalEventsController(NormalEventsService service, StatChangeService statChangeService) {
        this.normalEventsService = service;
        this.statChangeService = statChangeService;
    }

    // 처음 페이지 접근 시, 랜덤한 ID로 대사 1개 조회 후 보여줌
    @GetMapping("/dialogues/normal-events")
    public NormalEventsDTO getRandomEvent(){
        return normalEventsService.randomEvent();
    }

    @PostMapping("/event/{id}/choose")
    public ResponseEntity<StatChangeDTO> applyStatChange(
            @PathVariable int id,
            @RequestParam int choiceNumber,
            @RequestParam int memberId){

        StatChangeDTO statChangeDTO = statChangeService.applyChoice(id, choiceNumber, memberId);
        return ResponseEntity.ok(statChangeDTO);
    }



}
