package com.example.salt.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_choices")
@Data
@NoArgsConstructor
public class JobChoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String choiceText;
    private String resultDialogue;
    private int chStatMoney;
    private int chStatHealth;
    private int chStatMental;
    private int chStatRep;
    private String background;
}
