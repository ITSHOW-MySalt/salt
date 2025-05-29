package com.example.salt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "news_tb")
@Data
public class NewsEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String news;
}
