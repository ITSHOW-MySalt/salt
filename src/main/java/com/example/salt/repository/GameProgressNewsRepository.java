package com.example.salt.repository;

import com.example.salt.entity.NewsProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GameProgressNewsRepository extends JpaRepository<NewsProgressEntity, Integer> {

    // 정수형 필드 기준으로 조회
    List<NewsProgressEntity> findByGameProgressId(int gameProgressId);

    // 정수형 필드 기준으로 삭제
    @Modifying
    @Transactional
    void deleteByGameProgressId(int gameProgressId);

    // id로 삭제
    @Modifying
    @Transactional
    void deleteById(int id);
}
