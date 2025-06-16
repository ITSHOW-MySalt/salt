package com.example.salt.dto;

import com.example.salt.entity.NewsEntity;
import lombok.Data;

@Data
public class NewsDTO {
    private int id;
    private String news;


    public NewsDTO(NewsEntity entity) {
        this.id = entity.getId();
        this.news = entity.getNews();
    }
}
