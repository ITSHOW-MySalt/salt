package com.example.salt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "game_progress_news_tb")
@Getter
@Setter
public class NewsProgressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // game_progress_id 컬럼을 숫자로 직접 매핑
    @Column(name = "game_progress_id", nullable = false)
    private int gameProgressId;

    @Column(name = "news_id", nullable = false)
    private int newsId;
}

