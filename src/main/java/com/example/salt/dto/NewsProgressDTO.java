package com.example.salt.dto;

import com.example.salt.entity.NewsProgressEntity;
import lombok.Data;

@Data
public class NewsProgressDTO {

    private int id;
    private int gameProgressId;
    private int newsId;

    public NewsProgressDTO(NewsProgressEntity entity) {
        this.id = entity.getId();
        this.gameProgressId = entity.getGameProgressEntity() != null
                ? entity.getGameProgressEntity().getId()
                : 0; // 또는 예외 처리
        this.newsId = entity.getNewsId();
    }
}
