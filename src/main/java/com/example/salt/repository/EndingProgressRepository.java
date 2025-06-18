package com.example.salt.repository;

import com.example.salt.entity.EndingProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndingProgressRepository extends JpaRepository<EndingProgressEntity, Integer> {
}
