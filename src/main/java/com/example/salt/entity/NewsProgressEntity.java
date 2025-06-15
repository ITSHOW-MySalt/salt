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

    @ManyToOne
    @JoinColumn(name = "username_id")
    private GameProgressEntity gameProgressEntity;

    private int news_id;
}
