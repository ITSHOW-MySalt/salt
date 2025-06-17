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
            this.ch_stat_money = entity.getCh_stat1_Money();
            this.ch_stat_health = entity.getCh_stat1_Health();
            this.ch_stat_mental = entity.getCh_stat1_Mental();
            this.ch_stat_rep = entity.getCh_stat1_Rep();
        } else {
            this.ch_stat_money = entity.getCh_stat2_Money();
            this.ch_stat_health = entity.getCh_stat2_Health();
            this.ch_stat_mental = entity.getCh_stat2_Mental();
            this.ch_stat_rep = entity.getCh_stat2_Rep();
        }
    }
}
