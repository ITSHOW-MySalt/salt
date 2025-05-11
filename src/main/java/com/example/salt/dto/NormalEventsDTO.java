package com.example.salt.dto;

import lombok.Data;

@Data
public class NormalEventsDTO {
    private int id;
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
