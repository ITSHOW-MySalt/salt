package com.example.salt.controller;

import com.example.salt.dto.JobChoiceDTO;
import com.example.salt.service.JobChoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/dialogues")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class JobChoiceController {
    private final JobChoiceService service;

    @GetMapping("/job-choices")
    public List<JobChoiceDTO> getChoices() {
        return service.getAllChoices();
    }
}
