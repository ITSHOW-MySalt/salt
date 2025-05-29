package com.example.salt.repository;

import com.example.salt.entity.NewsEventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewsEventsRepository extends JpaRepository<NewsEventsEntity, Integer> {

    @Query(value = "SELECT COUNT(*) FROM `news_event_tb`", nativeQuery = true)
    long countRows();
}
