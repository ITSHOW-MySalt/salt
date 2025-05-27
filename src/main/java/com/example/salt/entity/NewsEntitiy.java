package com.example.salt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "news_sheet_tb")
@Data
public class NewsEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String news;
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
