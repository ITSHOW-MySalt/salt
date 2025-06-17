package com.example.salt.dto;

import com.example.salt.entity.NormalEventsEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NormalEventsDTO {
    private int id;
    private String dialogue;

    @JsonProperty("choice1")
    private String choice1Text;

    @JsonProperty("choice2")
    private String choice2Text;

    private int ch_stat1_Money;
    private int ch_stat1_Health;
    private int ch_stat1_Mental;
    private int ch_stat1_Rep;

    private int ch_stat2_Money;
    private int ch_stat2_Health;
    private int ch_stat2_Mental;
    private int ch_stat2_Rep;

    private String background;

    public NormalEventsDTO(NormalEventsEntity entity) {
        this.id = entity.getId();
        this.dialogue = entity.getDialogue();
        this.choice1Text = entity.getChoice1();
        this.choice2Text = entity.getChoice2();
        this.ch_stat1_Money = entity.getCh_stat1_Money();
        this.ch_stat1_Health = entity.getCh_stat1_Health();
        this.ch_stat1_Mental = entity.getCh_stat1_Mental();
        this.ch_stat1_Rep = entity.getCh_stat1_Rep();
        this.ch_stat2_Money = entity.getCh_stat2_Money();
        this.ch_stat2_Health = entity.getCh_stat2_Health();
        this.ch_stat2_Mental = entity.getCh_stat2_Mental();
        this.ch_stat2_Rep = entity.getCh_stat2_Rep();
        this.background = entity.getBackground();
    }
}
