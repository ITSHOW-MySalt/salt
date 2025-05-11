package com.example.salt.controller;

import com.example.salt.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam; // @RequestParam 사용을 위해 추가!

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "main";
    }

    @GetMapping("/user")
    public String showNicknamePage(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "username";
    }

    @PostMapping("/loginSuccess") // 닉네임 입력 후 호출 (gender.html로 이동)
    public String handleLoginSuccess(@ModelAttribute MemberDTO memberDTO, Model model) {
        model.addAttribute("memberDTO", memberDTO);
        return "gender"; // gender.html로 이동
    }

    @GetMapping("/nextPage") // gender.html에서 성별 선택 후 호출될 메소드
    public String showWelcomePage(@RequestParam("gender") String gender, Model model, @ModelAttribute MemberDTO memberDTO) {
        // 성별 값을 받아와서 처리 (여기서는 그냥 Model에 담아둠)
        model.addAttribute("selectedGender", gender);

        model.addAttribute("memberDTO", memberDTO);

        return "welcome"; // src/main/resources/templates/welcome.html 페이지 반환
    }
}
