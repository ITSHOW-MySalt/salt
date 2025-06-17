package com.example.salt.controller;

import com.example.salt.dto.EndingDTO;
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


}
