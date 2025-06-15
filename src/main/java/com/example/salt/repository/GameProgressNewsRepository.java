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

    // gameProgressEntity 객체의 id 필드로 조회
    List<NewsProgressEntity> findByGameProgressEntity_Id(int gameProgressId);

    @Modifying
    @Query("DELETE FROM NewsProgressEntity n WHERE n.gameProgressEntity.id = :gameProgressId")
    void deleteByGameProgressEntityId(@Param("gameProgressId") int gameProgressId);

    @Modifying
    @Transactional
    void deleteById(int id);
}
