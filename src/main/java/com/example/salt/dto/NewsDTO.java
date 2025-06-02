package com.example.salt.dto;

import com.example.salt.entity.NewsEntitiy;
import lombok.Data;

@Data
public class NewsDTO {
    private int id;
    private String news;


    public NewsDTO(NewsEntitiy entity) {
        this.id = entity.getId();
        this.news = entity.getNews();
    }
}
