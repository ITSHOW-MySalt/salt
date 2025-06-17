package com.example.salt.service;

import com.example.salt.dto.NewsEventsDTO;
import com.example.salt.entity.GameProgressEntity;
import com.example.salt.entity.MemberEntity;
import com.example.salt.entity.NewsProgressEntity;
import com.example.salt.repository.NewsEventsRepository;
import com.example.salt.repository.GameProgressNewsRepository;
import com.example.salt.repository.GameProgressRepository;
import com.example.salt.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsEventsService {

    private final NewsEventsRepository repository;
    private final GameProgressNewsRepository gameProgressNewsRepository;
    private final MemberRepository memberRepository;
    private final GameProgressRepository gameProgressRepository;

    @Autowired
    public NewsEventsService(
            NewsEventsRepository repository,
            GameProgressNewsRepository gameProgressNewsRepository,
            MemberRepository memberRepository,
            GameProgressRepository gameProgressRepository
    ) {
        this.repository = repository;
        this.gameProgressNewsRepository = gameProgressNewsRepository;
        this.memberRepository = memberRepository;
        this.gameProgressRepository = gameProgressRepository;
    }

    public long getRowCount() {
        return repository.countRows();
    }

    public NewsEventsDTO selectById(int id) {
        return repository.findById(id)
                .map(NewsEventsDTO::new)
                .orElse(null);
    }

    // userId 기반 뉴스 목록 조회
    public List<NewsProgressEntity> getSavedNewsByUserId(int userId) {
        MemberEntity member = memberRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("❌ 사용자 없음: " + userId));
        GameProgressEntity progress = gameProgressRepository.findByMember(member)
                .orElseThrow(() -> new RuntimeException("❌ 진행 정보 없음"));

        return gameProgressNewsRepository.findByGameProgressId(progress.getId());
    }

    // userId 기반 뉴스 삭제
    @Transactional
    public void deleteNewsProgressByUserId(int userId, int newsId) {
        MemberEntity member = memberRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("❌ 사용자 없음: " + userId));

        GameProgressEntity progress = gameProgressRepository.findByMember(member)
                .orElseThrow(() -> new RuntimeException("❌ 진행 정보 없음"));

        gameProgressNewsRepository.findByGameProgressId(progress.getId()).stream()
                .filter(n -> n.getNewsId() == newsId)
                .findFirst()
                .ifPresent(n -> gameProgressNewsRepository.deleteById(n.getId()));
    }
}

