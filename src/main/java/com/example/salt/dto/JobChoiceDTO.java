package com.example.salt.dto;

import com.example.salt.entity.JobChoiceEntity;
import lombok.Data;

@Data
public class JobChoiceDTO {
    private int id;
    private String choiceText;
    private String resultDialogue;
    private int chStatMoney;
    private int chStatHealth;
    private int chStatMental;
    private int chStatRep;
    private String background;

    public JobChoiceDTO(JobChoiceEntity e) {
        this.id = e.getId().intValue();
        this.choiceText = e.getChoiceText();
        this.resultDialogue = e.getResultDialogue();
        this.chStatMoney = e.getChStatMoney();
        this.chStatHealth = e.getChStatHealth();
        this.chStatMental = e.getChStatMental();
        this.chStatRep = e.getChStatRep();
        this.background = e.getBackground();
    }
}
