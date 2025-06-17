package com.example.salt.dto;

import com.example.salt.entity.GameProgressEntity;
import lombok.Data;

@Data
public class GameProgressDTO {
    private int id;
    private int username_id; // MemberEntity의 id
    private int gender;
    private int current_day;

    private int ch_stat_money;
    private int ch_stat_health;
    private int ch_stat_mental;
    private int ch_stat_rep;

    public GameProgressDTO(GameProgressEntity entity) {
        this.id = entity.getId();
        this.username_id = entity.getMember().getId();
        this.gender = entity.getGender();
        this.current_day = entity.getCurrent_day();
        this.ch_stat_money = entity.getCh_stat_money();
        this.ch_stat_health = entity.getCh_stat_health();
        this.ch_stat_mental = entity.getCh_stat_mental();
        this.ch_stat_rep = entity.getCh_stat_rep();
    }
}
