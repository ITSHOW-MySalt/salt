package com.example.salt.controller;

import com.example.salt.dto.EndingDTO;
import com.example.salt.service.EndingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EndingController {

    private final EndingService endingService;

    public EndingController(EndingService endingService) {
        this.endingService = endingService;
    }

    @GetMapping("ending/{id}")
    public ResponseEntity<EndingDTO> getEnding(@PathVariable int id){
        EndingDTO endingDTO = endingService.getEndingById(id);
        return ResponseEntity.ok(endingDTO);
    }

    @GetMapping("/check-ending")
    public ResponseEntity<EndingDTO> checkEnding(@RequestParam String username) {
        EndingDTO endingDTO = endingService.checkEnding(username);
        if (endingDTO == null) {
            return ResponseEntity.noContent().build(); // 조건 불충족 시 204 No Content
        }
        return ResponseEntity.ok(endingDTO);
    }


}
