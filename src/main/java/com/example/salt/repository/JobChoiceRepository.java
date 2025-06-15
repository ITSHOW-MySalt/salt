package com.example.salt.repository;

import com.example.salt.entity.JobChoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobChoiceRepository extends JpaRepository<JobChoiceEntity, Long> {
    // 필터링 없이 전체 조회만 필요함
}
