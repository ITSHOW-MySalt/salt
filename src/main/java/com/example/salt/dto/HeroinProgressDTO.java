package com.example.salt.dto;

import lombok.Data;

@Data
public class HeroinProgressDTO {
    private int id;
    private int gameProgressId;
    private int heroinA_affection;
    private int heroinB_affection;
    private int heroinA_meetCount;
    private int heroinB_meetCount;
}
