package com.example.salt.repository;

import com.example.salt.entity.GameProgressEntity;
import com.example.salt.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameProgressRepository extends JpaRepository<GameProgressEntity, Integer> {
    boolean existsByMember(MemberEntity member);
}
