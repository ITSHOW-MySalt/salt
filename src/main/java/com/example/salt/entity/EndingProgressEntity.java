package com.example.salt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="game_progress_ending")
@Data
public class EndingProgressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "game_progress_id")
    private GameProgressEntity gameProgress;

    @ManyToOne
    @JoinColumn(name = "ending_id")
    private EndingEntity ending;

}
