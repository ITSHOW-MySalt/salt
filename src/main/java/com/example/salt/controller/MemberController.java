package com.example.salt.controller;

import com.example.salt.dto.MemberDTO;
import com.example.salt.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String login(MemberDTO dto) {
        return "login_tmp";
    }

    @PostMapping("/login_tmp")
    public String showResultPage(@RequestParam String username, Model model) {
        boolean success = memberService.saveIfNew(username);
        model.addAttribute("username", username);
        model.addAttribute("isSaved", success);
        return "loginresult_tmp";
    }




}
