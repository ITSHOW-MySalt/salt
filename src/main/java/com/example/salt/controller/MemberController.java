package com.example.salt.controller;

import com.example.salt.dto.MemberDTO;
import com.example.salt.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/gender")
    public String showResultPage(@Valid @ModelAttribute MemberDTO memberDTO, BindingResult bindingResult, Model model) {
        String username = memberDTO.getUsername();

        if(bindingResult.hasErrors()) {
//            model.addAttribute("error", bindingResult.getFieldError().getDefaultMessage());
            return "username";
        }

        try {
            boolean success = memberService.saveIfNew(username);

            model.addAttribute("username", username);
            model.addAttribute("isSaved", success);
            return "gender";
        } catch (IllegalArgumentException e){
            model.addAttribute("error", "존재하는 이름입니다");
            return "username";
        }
    }

    @PostMapping("/start")
    public String startGame(@ModelAttribute MemberDTO memberDTO, Model model) {
        String username = memberDTO.getUsername();
        Integer gender = memberDTO.getGender();

        memberService.updateGender(username, gender);

        model.addAttribute("username", username);
        System.out.println(username);
        System.out.println(gender);

        return "welcome";
    }
}
