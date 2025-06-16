package com.example.salt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "game_progress_news_tb")
@Data
public class NewsProgressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // game_progress_id 외래키 매핑
    @ManyToOne
    @JoinColumn(name = "game_progress_id", nullable = false)
    private GameProgressEntity gameProgressEntity;

    // news_id 컬럼 매핑 (기본 타입)
    @Column(name = "news_id", nullable = false)
    private int newsId;

}
