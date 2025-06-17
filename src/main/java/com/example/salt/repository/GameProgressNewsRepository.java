package com.example.salt.repository;

import com.example.salt.entity.NewsProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GameProgressNewsRepository extends JpaRepository<NewsProgressEntity, Integer> {

    List<NewsProgressEntity> findByGameProgressId(int gameProgressId);

    @Modifying
    @Transactional
    void deleteByGameProgressId(int gameProgressId);

    @Modifying
    @Transactional
    void deleteById(int id);
}
