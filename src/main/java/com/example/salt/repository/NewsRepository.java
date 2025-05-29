package com.example.salt.repository;

import com.example.salt.entity.NewsEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository  extends JpaRepository<NewsEntitiy, Integer> {
}
