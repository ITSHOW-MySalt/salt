package com.example.salt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GameProgressDTO {
    private int id;
    private int username_id;
    private int gender;

    private int current_day;

    private int ch_stat_money;
    private int ch_stat_health;
    private int ch_stat_mental;
    private int ch_stat_rep;
}
