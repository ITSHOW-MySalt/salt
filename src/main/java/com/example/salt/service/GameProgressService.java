package com.example.salt.service;

import com.example.salt.dto.GameProgressDTO;
import com.example.salt.entity.GameProgressEntity;
import com.example.salt.entity.MemberEntity;
import com.example.salt.repository.GameProgressRepository;
import com.example.salt.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class GameProgressService {

    private final GameProgressRepository gameProgressRepository;
    private final MemberRepository memberRepository;

    public GameProgressService(GameProgressRepository gameProgressRepository, MemberRepository memberRepository) {
        this.gameProgressRepository = gameProgressRepository;
        this.memberRepository = memberRepository;
    }

    public GameProgressDTO initMember(String username) {
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다."));

        boolean exists = gameProgressRepository.existsByMember(member);
        GameProgressEntity progress;

        if (!exists) {
            progress = new GameProgressEntity();

            progress.setMember(member);
            progress.setGender(member.getGender());
            progress.setCurrent_day(1);
            progress.setCh_stat_health(50);
            progress.setCh_stat_mental(50);
            progress.setCh_stat_money(50);
            progress.setCh_stat_rep(50);
            gameProgressRepository.save(progress);
        } else {
            progress = gameProgressRepository.findByMember(member)
                    .orElseThrow(() -> new RuntimeException("진행 정보가 없습니다."));
        }
        return new GameProgressDTO(progress);
    }

    public int getCurrentDayByUsername(String username) {
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다."));

        GameProgressEntity progress = gameProgressRepository.findByMember(member)
                .orElseThrow(() -> new RuntimeException("해당 유저의 게임 진행 정보가 없습니다."));

        return progress.getCurrent_day();
    }

    public void incrementDay(String username) {
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다."));

        GameProgressEntity progress = gameProgressRepository.findByMember(member)
                .orElseThrow(() -> new RuntimeException("해당 유저의 게임 진행 정보가 없습니다."));

        progress.setCurrent_day(progress.getCurrent_day() + 1);
        gameProgressRepository.save(progress);
    }

    public void resetProgress(String username) {
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다"));

        GameProgressEntity progress = gameProgressRepository.findByMember(member)
                .orElseThrow(() -> new RuntimeException("게임 진행 정보가 없습니다"));

        progress.setCurrent_day(1);
        progress.setCh_stat_money(50);
        progress.setCh_stat_health(50);
        progress.setCh_stat_mental(50);
        progress.setCh_stat_rep(50);

        gameProgressRepository.save(progress);
    }

    // 새로 추가한 메서드 - userId 기준 gameProgressId 조회
    public Integer getGameProgressIdByUserId(int userId) {
        MemberEntity member = memberRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다. ID: " + userId));

        GameProgressEntity progress = gameProgressRepository.findByMember(member)
                .orElseThrow(() -> new RuntimeException("해당 유저의 게임 진행 정보가 없습니다. ID: " + userId));

        return progress.getId();
    }
}
