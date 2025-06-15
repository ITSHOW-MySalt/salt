package com.example.salt.repository;

import com.example.salt.entity.NormalEventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NormalEventsRepository extends JpaRepository<NormalEventsEntity, Integer> {

    List<NormalEventsEntity> findAllByOrderById();
}
