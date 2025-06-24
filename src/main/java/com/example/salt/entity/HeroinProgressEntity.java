package com.example.salt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Optional;

@Entity
@Table(name = "heroin_progress_tb")
@Data
public class HeroinProgressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "game_progress_id", nullable = false)
    private GameProgressEntity gameProgress;

    private int heroinA_affection;
    private int heroinB_affection;
    private int heroinA_meetCount;
    private int heroinB_meetCount;

}
