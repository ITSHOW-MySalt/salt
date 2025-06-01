package com.example.salt.service;

import com.example.salt.dto.MemberDTO;
import com.example.salt.entity.MemberEntity;
import com.example.salt.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean saveNewMember(String username, Integer gender) {
        if(!memberRepository.existsByUsername(username)) {
            MemberDTO dto = new MemberDTO();
            dto.setUsername(username);
            dto.setGender(gender);

            MemberEntity entity = MemberEntity.toMemberEntity(dto);
            memberRepository.save(entity);
            return true;
        }
        else {
            throw new IllegalArgumentException("이미 존재하는 사용자 이름입니다.");
        }
    }

}
