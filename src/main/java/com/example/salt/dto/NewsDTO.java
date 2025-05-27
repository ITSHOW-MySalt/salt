package com.example.salt.dto;

import com.example.salt.entity.NewsEntitiy;
import lombok.Data;

@Data
public class NewsDTO {
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

    public NewsDTO(NewsEntitiy entity) {
        this.id = entity.getId();
        this.dialogue = entity.getDialogue();
        this.choice1 = entity.getChoice1();
        this.choice2 = entity.getChoice2();
        this.ch_stat1_money = entity.getCh_stat1_money();
        this.ch_stat1_health = entity.getCh_stat1_health();
        this.ch_stat1_mental = entity.getCh_stat1_mental();
        this.ch_stat1_rep = entity.getCh_stat1_rep();
        this.ch_stat2_money = entity.getCh_stat2_money();
        this.ch_stat2_health = entity.getCh_stat2_health();
        this.ch_stat2_mental = entity.getCh_stat2_mental();
        this.ch_stat2_rep = entity.getCh_stat2_rep();
        this.background = entity.getBackground();
    }
}
