package com.example.salt.repository;

import com.example.salt.entity.GameProgressEntity;
import com.example.salt.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface GameProgressRepository extends JpaRepository<GameProgressEntity, Integer> {
    boolean existsByMember(MemberEntity member);

    Optional<GameProgressEntity> findByMember(MemberEntity member);
    Optional<GameProgressEntity> findByMemberUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE GameProgressEntity gp SET gp.ending_list = :endingList WHERE gp.member.username = :username")
    void updateEndingListByMemberUsername(String username, int endingList);

}
