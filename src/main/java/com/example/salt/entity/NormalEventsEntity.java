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

    @Column(name = "ch_stat1_Money")
    private int ch_stat1_Money;

    @Column(name = "ch_stat1_Health")
    private int ch_stat1_Health;

    @Column(name = "ch_stat1_Mental")
    private int ch_stat1_Mental;

    @Column(name = "ch_stat1_Rep")
    private int ch_stat1_Rep;

    @Column(name = "ch_stat2_Money")
    private int ch_stat2_Money;

    @Column(name = "ch_stat2_Health")
    private int ch_stat2_Health;

    @Column(name = "ch_stat2_Mental")
    private int ch_stat2_Mental;

    @Column(name = "ch_stat2_Rep")
    private int ch_stat2_Rep;

    private String background;
}
