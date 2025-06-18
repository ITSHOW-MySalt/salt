package com.example.salt.service;

import com.example.salt.dto.EndingDTO;
import com.example.salt.dto.GameProgressDTO;
import com.example.salt.entity.EndingEntity;
import com.example.salt.entity.GameProgressEntity;
import com.example.salt.entity.MemberEntity;
import com.example.salt.repository.EndingRepository;
import com.example.salt.repository.GameProgressRepository;
import com.example.salt.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndingService {

    private final EndingRepository endingRepository;
    private final GameProgressRepository gameProgressRepository;
    private final MemberRepository memberRepository;

    public EndingService(EndingRepository endingRepository, GameProgressRepository gameProgressRepository, MemberRepository memberRepository) {
        this.endingRepository = endingRepository;
        this.gameProgressRepository = gameProgressRepository;
        this.memberRepository = memberRepository;
    }

    public EndingDTO getEndingById(int id){
        return endingRepository.findById(id).map(EndingDTO::new).orElse(null);
    }

    public List<EndingDTO> endingList(){
        List<EndingEntity> allEnding = endingRepository.findAll();
        return allEnding.stream()
                .map(EndingDTO::new)
                .toList();
    }

    public EndingDTO checkEnding(String username, int money, int health, int mental, int rep){
        MemberEntity memberEntity= memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("멤버가 존재하지 않습니다."));

        GameProgressEntity gameProgressEntity = gameProgressRepository.findByMember(memberEntity)
                .orElseThrow(() -> new RuntimeException("멤버가 존재하지 않습니다."));

        Integer endingId = null;
        if(health == 0){
            endingId = 4;
        }
        else if(mental == 0){
            endingId = 5;
        }
        else if(rep==0) {
            endingId = 6;
        }
        else if(money <=40 ){
            endingId = 1;
        }
        else if(money>40 && money<=80){
            endingId = 2;
        }
        else if(money>80){
            endingId = 3;
        }
        else {
            return null;
        }

        EndingEntity endingEntity = endingRepository.findById(endingId)
                .orElseThrow(() -> new RuntimeException("엔딩이 존재하지 않습니다"));

        System.out.println("endingEntity = " + endingEntity);

        if(endingEntity == null) return null;

        return new EndingDTO(endingEntity);




    }

}
