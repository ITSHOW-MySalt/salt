package com.example.salt.controller;
import com.example.salt.dto.MemberDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "main";
    }

    @GetMapping("/user")
    public String showNicknamePage(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "username";
    }
}
