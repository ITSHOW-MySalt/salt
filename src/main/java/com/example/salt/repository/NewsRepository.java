package com.example.salt.repository;

import com.example.salt.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository  extends JpaRepository<NewsEntity, Integer> {

    @Query(value = "SELECT id FROM news_tb ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Integer> findRandomNewsIds(int limit);
    @Query("SELECT n.id FROM NewsEntity n")
    List<Integer> findAllIds();


}
