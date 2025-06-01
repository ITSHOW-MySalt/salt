package com.example.salt.dto;

import com.example.salt.entity.MemberEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@Data
public class MemberDTO {
    @NotBlank(message = "이름을 입력해주세요")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{1,15}$", message = "이름은 특수문자를 포함하지 않은 1~15자리여야 합니다")
    private String username;
    private Integer gender;
}
