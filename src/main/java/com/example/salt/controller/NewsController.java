package com.example.salt.controller;

import com.example.salt.dto.NewsDTO;
import com.example.salt.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsController {

    public final NewsService service;

    public NewsController(NewsService service) {
        this.service = service;
    }


    @GetMapping("/news")
    public List<NewsDTO> getnews() {
        List<NewsDTO> result = new ArrayList<>();

        long rowCount = service.getRowCount();

        for(int i=1; i<=rowCount; i++) {
            NewsDTO dto = service.selectById(i);
            if(dto != null) {
                result.add(dto);
            }
        }

        return result;
    }
}
