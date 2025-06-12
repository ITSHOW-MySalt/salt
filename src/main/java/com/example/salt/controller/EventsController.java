package com.example.salt.controller;

import com.example.salt.service.GameProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EventsController {
    private static final int plan[] = {
            0, 4, 3, 5, 1, 5, 5, 3, 1, 1, 1, 4, 3, 5,
            1, 1, 4, 3, 0, 5, 5, 4, 3, 1, 0, 1, 5, 0,
            1, 4, 1, 1, 3, 4, 5, 0, 1, 3, 4, 1, 5, 5,
            3, 5, 4, 1, 1, 3, 5, 6
    };

    @Autowired
    private GameProgressService gameProgressService;

    @GetMapping("/events/next")
    public int getNextEvent(@RequestParam String username) {
        int day = gameProgressService.getCurrentDayByUsername(username);

        if (day <= 0 || day > plan.length) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }

        int eventTypeCode = plan[day - 1];
        return eventTypeCode;
    }
}
