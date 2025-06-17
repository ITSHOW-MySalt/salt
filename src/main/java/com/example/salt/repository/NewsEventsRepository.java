package com.example.salt.repository;

import com.example.salt.entity.NewsEventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsEventsRepository extends JpaRepository<NewsEventsEntity, Integer> {

    // 전체 뉴스 이벤트 개수 (필요 시 유지)
    @Query(value = "SELECT COUNT(*) FROM news_event_tb", nativeQuery = true)
    long countRows();

    // 여러 ID로 뉴스 이벤트 가져오기 (사용자별 뉴스 ID 목록 조회용)
    List<NewsEventsEntity> findByIdIn(List<Integer> ids);
}
