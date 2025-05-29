package com.example.salt.controller;

import com.example.salt.dto.NewsDTO;
import com.example.salt.dto.NewsEventsDTO;
import com.example.salt.service.NewsEventsService;
import com.example.salt.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsEventsController {

    public final NewsEventsService service;

    public NewsEventsController(NewsEventsService service) {
        this.service = service;
    }

    @GetMapping("/newsEvent")
    public List<NewsEventsDTO> getnews() {
        List<NewsEventsDTO> result = new ArrayList<>();

        long rowCount = service.getRowCount();

        for(int i=1; i<=rowCount; i++) {
            NewsEventsDTO dto = service.selectById(i);
            if(dto != null) {
                result.add(dto);
            }
        }

        return result;
    }
}
