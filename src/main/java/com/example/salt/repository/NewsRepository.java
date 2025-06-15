package com.example.salt.repository;

import com.example.salt.entity.NewsEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository  extends JpaRepository<NewsEntitiy, Integer> {

    @Query(value = "SELECT COUNT(*) FROM `news_tb`", nativeQuery = true)
    long countRows();

    List<NewsEntitiy> findAllById();

}
