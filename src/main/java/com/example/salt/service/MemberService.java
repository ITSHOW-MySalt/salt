package com.example.salt.service;

import com.example.salt.dto.MemberDTO;
import com.example.salt.entity.MemberEntity;
import com.example.salt.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public boolean saveIfNew(String username) {
        if(!memberRepository.existsById(username)) {
            MemberDTO dto = new MemberDTO();
            dto.setUsername(username);

            MemberEntity entity = MemberEntity.toMemberEntity(dto);
            memberRepository.save(entity);
            return true;
        }
        return false;
    }

}
