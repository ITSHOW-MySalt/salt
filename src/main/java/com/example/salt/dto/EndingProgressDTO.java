package com.example.salt.dto;

import com.example.salt.entity.EndingEntity;
import com.example.salt.entity.EndingProgressEntity;
import lombok.Data;

@Data
public class EndingProgressDTO {
    private int id;
    private int game_progress_id;
    private String endingname;

    public EndingProgressDTO(EndingProgressEntity entity){
        this.id = entity.getId();
        this.game_progress_id = entity.getGameProgress().getId();
        this.endingname = entity.getEnding().getEndingname();
    }
}
