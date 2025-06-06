package com.example.salt.dto;

import com.example.salt.entity.NormalEventsEntity;
import lombok.Data;

@Data
public class StatChangeDTO {
    private int ch_stat_money;
    private int ch_stat_health;
    private int ch_stat_mental;
    private int ch_stat_rep;

    public StatChangeDTO(NormalEventsEntity entity, int choiceNumber) {
        if (choiceNumber == 1) {
            this.ch_stat_money = entity.getCh_stat1_money();
            this.ch_stat_health = entity.getCh_stat1_health();
            this.ch_stat_mental = entity.getCh_stat1_mental();
            this.ch_stat_rep = entity.getCh_stat1_rep();
        } else {
            this.ch_stat_money = entity.getCh_stat2_money();
            this.ch_stat_health = entity.getCh_stat2_health();
            this.ch_stat_mental = entity.getCh_stat2_mental();
            this.ch_stat_rep = entity.getCh_stat2_rep();
        }
    }
}
