package com.example.salt.service;

import com.example.salt.dto.StatChangeDTO;
import com.example.salt.entity.GameProgressEntity;
import com.example.salt.entity.MemberEntity;
import com.example.salt.entity.NormalEventsEntity;
import com.example.salt.repository.GameProgressRepository;
import com.example.salt.repository.MemberRepository;
import com.example.salt.repository.NormalEventsRepository;
import org.springframework.stereotype.Service;

@Service
public class StatChangeService {

    private final NormalEventsRepository normalEventsRepository;
    private final GameProgressRepository gameProgressRepository;
    private final MemberRepository memberRepository;

    public StatChangeService(NormalEventsRepository normalEventsRepository, GameProgressRepository gameProgressRepository, MemberRepository memberRepository) {
        this.normalEventsRepository = normalEventsRepository;
        this.gameProgressRepository = gameProgressRepository;
        this.memberRepository = memberRepository;
    }

    public StatChangeDTO applyChoice(int eventId, int choiceNumber, int memberId){
        NormalEventsEntity normalEvents = normalEventsRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("이벤트가 존재하지 않습니다."));

        MemberEntity member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("멤버가 존재하지 않습니다."));

        GameProgressEntity gameProgress = gameProgressRepository.findByMember(member)
                .orElseThrow(() -> new RuntimeException("게임 진행 정보가 존재하지 않습니다."));

        if(choiceNumber == 1) {
            gameProgress.setCh_stat_money(gameProgress.getCh_stat_money() + normalEvents.getCh_stat1_Money());
            gameProgress.setCh_stat_mental(gameProgress.getCh_stat_mental() + normalEvents.getCh_stat1_Mental());
            gameProgress.setCh_stat_health(gameProgress.getCh_stat_health() + normalEvents.getCh_stat1_Health());
            gameProgress.setCh_stat_rep(gameProgress.getCh_stat_rep() + normalEvents.getCh_stat1_Rep());
        } else if(choiceNumber == 2){
            gameProgress.setCh_stat_money(gameProgress.getCh_stat_money() + normalEvents.getCh_stat2_Money());
            gameProgress.setCh_stat_mental(gameProgress.getCh_stat_mental() + normalEvents.getCh_stat2_Mental());
            gameProgress.setCh_stat_health(gameProgress.getCh_stat_health() + normalEvents.getCh_stat2_Health());
            gameProgress.setCh_stat_rep(gameProgress.getCh_stat_rep() + normalEvents.getCh_stat2_Rep());
        }

        gameProgressRepository.save(gameProgress);

        return new StatChangeDTO(normalEvents, choiceNumber);
    }
}
