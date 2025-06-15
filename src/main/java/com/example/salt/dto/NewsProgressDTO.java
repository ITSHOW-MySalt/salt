package com.example.salt.dto;

import com.example.salt.entity.NewsProgressEntity;
import lombok.Data;

@Data
public class NewsProgressDTO {

    private int id;
    private int game_progress_id;
    private int news_id;

    public NewsProgressDTO(NewsProgressEntity entity) {
        this.id = entity.getId();
        this.game_progress_id = entity.getId();
        this.news_id = entity.getNews_id();
    }

}

