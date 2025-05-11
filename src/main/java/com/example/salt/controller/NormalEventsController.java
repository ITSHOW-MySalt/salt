package com.example.salt.controller;

import com.example.salt.dto.NormalEventsDTO;
import com.example.salt.service.NormalEventsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NormalEventsController {

    private final NormalEventsService service;

    // 생성자 주입
    public NormalEventsController(NormalEventsService service) {
        this.service = service;
    }

    // 처음 페이지 접근 시, 랜덤한 ID로 대사 1개 조회 후 보여줌
    @GetMapping("/dialogues/normal-events")
    public String normalEvents(Model model) {
        int selectId = (int) (Math.random() * 18);  // 0~17 범위의 랜덤 ID
        NormalEventsDTO dto = service.selectById(selectId);  // DTO 조회
        model.addAttribute("dto", dto);  // 모델에 담아서 HTML로 전달
        return "event_test";  // Thymeleaf 템플릿 페이지
    }
}
