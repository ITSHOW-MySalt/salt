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
        this.gameProgressId = entity.getGameProgressId();  // 정수형 필드 직접 사용
        this.newsId = entity.getNewsId();
    }
}
