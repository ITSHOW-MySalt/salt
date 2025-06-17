package com.example.salt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "news_event_tb")
@Data
public class NewsEventsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 고유한 기본 키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id") // news_id 외래키로 연결
    private NewsEntity news;

    private String dialogue;
    private String choice1;
    private String choice2;

    private int ch_stat1_money;
    private int ch_stat1_health;
    private int ch_stat1_mental;
    private int ch_stat1_rep;

    private int ch_stat2_money;
    private int ch_stat2_health;
    private int ch_stat2_mental;
    private int ch_stat2_rep;

    private String background;
}
