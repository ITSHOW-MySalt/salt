package com.example.salt.service;

import com.example.salt.dto.NewsDTO;
import com.example.salt.entity.NewsEntitiy;
import com.example.salt.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public NewsService(NewsRepository repository) {
        this.newsRepository = repository;
    }

    public long getRowCount(){
        return newsRepository.countRows();
    }

    public NewsDTO selectById(int selectId) {
        return newsRepository.findById(selectId)
                .map(NewsDTO::new)
                .orElse(null);
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
