package com.example.salt.service;

import com.example.salt.dto.GameProgressDTO;
import com.example.salt.dto.MemberDTO;
import com.example.salt.entity.GameProgressEntity;
import com.example.salt.entity.MemberEntity;
import com.example.salt.repository.GameProgressRepository;
import com.example.salt.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameProgressService {


    private final GameProgressRepository gameProgressRepository;
    private final MemberRepository memberRepository;

    public GameProgressService(GameProgressRepository gameProgressRepository, MemberRepository memberRepository) {
        this.gameProgressRepository = gameProgressRepository;
        this.memberRepository = memberRepository;
    }

    public void initMember(String username) {
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다."));

        boolean exists = gameProgressRepository.existsByMember(member);

        if(!exists) {
            GameProgressEntity progress = new GameProgressEntity();

            progress.setMember(member);
            progress.setGender(member.getGender());
            progress.setCurrent_day(1);
            progress.setCh_stat_health(0);
            progress.setCh_stat_mental(0);
            progress.setCh_stat_money(0);
            progress.setCh_stat_rep(0);
            gameProgressRepository.save(progress);
        }
    }

    public int getCurrentDayByUsername(String username) {
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다."));

        GameProgressEntity progress = gameProgressRepository.findByMember(member);
        if (progress == null) {
            throw new RuntimeException("해당 유저의 게임 진행 정보가 없습니다.");
        }
        return progress.getCurrent_day();
    }


}
