package com.example.salt.controller;

import com.example.salt.dto.NormalEventsDTO;
import com.example.salt.service.NormalEventsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormalEventsController {

    private final NormalEventsService service;

    public NormalEventsController(NormalEventsService service) {
        this.service = service;
    }

    @GetMapping("/dialogues/normal-events")
    public String normalEvents(Model model) {
        long rowCount = service.getRowCount();
        if (rowCount == 0) {
            return "no-data"; // 데이터가 없는 경우 예외 처리
        }

        int selectId = (int) (Math.random() * rowCount) + 1; // 1부터 rowCount까지 중 랜덤 ID
        NormalEventsDTO dto = service.selectById(selectId);
        model.addAttribute("dto", dto);
        return "/index";
    }
}

