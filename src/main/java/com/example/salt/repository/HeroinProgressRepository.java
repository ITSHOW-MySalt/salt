package com.example.salt.repository;

import com.example.salt.entity.HeroinProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeroinProgressRepository extends JpaRepository<HeroinProgressEntity, Long> {

    // 게임 진행 ID로 조회 (gameProgress가 엔티티면 맞게 바꿔야 함)
    Optional<HeroinProgressEntity> findByGameProgressId(int gameProgressId);

    boolean existsByGameProgressId(int gameProgressId);
}
