package com.example.salt.dto;

import com.example.salt.entity.EndingEntity;
import lombok.Data;

@Data
public class EndingDTO {
    private int id;
    private String endingname;
    private String imglink;

    public  EndingDTO(EndingEntity entity){
        this.id = entity.getId();
        this.endingname = entity.getEndingname();
        this.imglink = entity.getImglink();
    }
}
