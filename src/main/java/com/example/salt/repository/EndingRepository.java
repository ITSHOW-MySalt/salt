package com.example.salt.repository;

import com.example.salt.entity.EndingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndingRepository extends JpaRepository<EndingEntity, Integer> {


}
