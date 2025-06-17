package com.example.salt.service;

import com.example.salt.entity.NewsEntity;
import com.example.salt.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public long getNewsCount() {
        return newsRepository.count();
    }

    public List<Integer> getRandomNewsIds(int count) {
        List<Integer> allIds = newsRepository.findAllIds(); // 모든 뉴스 ID 불러오기
        Collections.shuffle(allIds); // 무작위 섞기
        return allIds.stream().distinct().limit(count).collect(Collectors.toList()); // 중복 제거 후 n개 추출
    }

    public NewsEntity getNewsById(int id) {
        Optional<NewsEntity> optionalNews = newsRepository.findById(id);
        if(optionalNews.isEmpty()) {
            System.out.println("뉴스 조회 실패 id=" + id);
            return null;
        }
        System.out.println("뉴스 조회 성공 id=" + id);
        return optionalNews.get();
    }

//    public NewsDTO randomNews(){
//        List<NewsEntitiy> allNews = newsRepository.findAllById();
//        int randomIndex;
//
//        if(allNews.isEmpty()){
//            return null;
//        }
//
//        for(int i=1; i<=3; i++){
//            randomIndex = (int) (Math.random() * allNews.size());
//
//        }
//
//
//    }
}
