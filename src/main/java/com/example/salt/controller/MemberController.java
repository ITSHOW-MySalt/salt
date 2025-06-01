package com.example.salt.controller;

import com.example.salt.dto.MemberDTO;
import com.example.salt.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/user")
    public ResponseEntity<Map<String, Object>> showResultPage(@Valid @RequestBody MemberDTO memberDTO) {
        Map<String, Object> response = new HashMap<>();
        String username = memberDTO.getUsername();
        Integer gender = memberDTO.getGender();

        System.out.println("서버로 들어온 데이터: username=" + memberDTO.getUsername() + ", gender=" + memberDTO.getGender());

        try {
            boolean success = memberService.saveNewMember(username, gender);
            response.put("username", username);
            response.put("gender", gender);
            response.put("isSaved", success);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("error", "존재하는 이름입니다");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
