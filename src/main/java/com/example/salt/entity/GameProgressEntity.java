    package com.example.salt.entity;

    import jakarta.persistence.*;
    import lombok.Data;

    import java.time.LocalDate;

    @Entity
    @Table(name = "game_progress_tb")
    @Data
    public class GameProgressEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "username_id")
        private MemberEntity member;

        private int gender;

        private int current_day;

        private int ch_stat_money;
        private int ch_stat_health;
        private int ch_stat_mental;
        private int ch_stat_rep;
        private int ending_list;
    }
