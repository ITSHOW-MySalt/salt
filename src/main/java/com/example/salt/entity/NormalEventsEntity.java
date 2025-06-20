package com.example.salt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "normalevents_tb")
@Data
public class NormalEventsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dialogue;

    private String choice1;
    private String choice2;

    @Column(name = "ch_stat1_money")
    private int ch_stat1_money;

    @Column(name = "ch_stat1_health")
    private int ch_stat1_health;

    @Column(name = "ch_stat1_mental")
    private int ch_stat1_mental;

    @Column(name = "ch_stat1_rep")
    private int ch_stat1_rep;

    @Column(name = "ch_stat2_money")
    private int ch_stat2_money;

    @Column(name = "ch_stat2_health")
    private int ch_stat2_health;

    @Column(name = "ch_stat2_mental")
    private int ch_stat2_mental;

    @Column(name = "ch_stat2_rep")
    private int ch_stat2_rep;

    private String background;
}
