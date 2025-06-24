package com.example.salt.service;

import com.example.salt.entity.GameProgressEntity;
import com.example.salt.entity.HeroinProgressEntity;
import com.example.salt.repository.GameProgressRepository;
import com.example.salt.repository.HeroinProgressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HeroinProgressService {

    private final HeroinProgressRepository heroinRepo;
    private final GameProgressRepository gameProgressRepo;

    public HeroinProgressService(HeroinProgressRepository heroinRepo, GameProgressRepository gameProgressRepo) {
        this.heroinRepo = heroinRepo;
        this.gameProgressRepo = gameProgressRepo;
    }

    public Optional<HeroinProgressEntity> getByGameProgressId(int gameProgressId) {
        return heroinRepo.findByGameProgressId(gameProgressId);
    }

    public HeroinProgressEntity incrementMeetCount(int gameProgressId, String target) {
        HeroinProgressEntity entity = heroinRepo.findByGameProgressId(gameProgressId)
                .orElseThrow(() -> new IllegalArgumentException("진행 정보 없음"));

        if ("A".equals(target)) {
            entity.setHeroinA_meetCount(entity.getHeroinA_meetCount() + 1);
        } else if ("B".equals(target)) {
            entity.setHeroinB_meetCount(entity.getHeroinB_meetCount() + 1);
        }
        return heroinRepo.save(entity);
    }

    public HeroinProgressEntity increaseAffection(int gameProgressId, String target, int amount) {
        HeroinProgressEntity entity = heroinRepo.findByGameProgressId(gameProgressId)
                .orElseThrow(() -> new IllegalArgumentException("진행 정보 없음"));

        if ("A".equals(target)) {
            entity.setHeroinA_affection(entity.getHeroinA_affection() + amount);
        } else if ("B".equals(target)) {
            entity.setHeroinB_affection(entity.getHeroinB_affection() + amount);
        }
        return heroinRepo.save(entity);
    }

    public boolean initProgressIfNotExist(int gameProgressId) {
        if (heroinRepo.existsByGameProgressId(gameProgressId)) {
            return false;
        }

        GameProgressEntity gameProgress = gameProgressRepo.findById(gameProgressId)
                .orElseThrow(() -> new IllegalArgumentException("게임 진행 정보 없음"));

        HeroinProgressEntity entity = new HeroinProgressEntity();
        entity.setGameProgress(gameProgress);
        entity.setHeroinA_affection(0);
        entity.setHeroinB_affection(0);
        entity.setHeroinA_meetCount(0);
        entity.setHeroinB_meetCount(0);

        heroinRepo.save(entity);
        return true;
    }

    @Transactional
    public void resetHeroinProgress(int gameProgressId) {
        Optional<HeroinProgressEntity> progressOpt = heroinRepo.findByGameProgressId(gameProgressId);
        if (progressOpt.isPresent()) {
            HeroinProgressEntity entity = progressOpt.get();
            entity.setHeroinA_affection(0);
            entity.setHeroinB_affection(0);
            entity.setHeroinA_meetCount(0);
            entity.setHeroinB_meetCount(0);
            heroinRepo.save(entity);
        }
    }

}
