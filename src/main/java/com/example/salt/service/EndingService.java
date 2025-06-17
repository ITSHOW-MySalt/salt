package com.example.salt.service;

import com.example.salt.dto.EndingDTO;
import com.example.salt.entity.EndingEntity;
import com.example.salt.repository.EndingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndingService {

    private final EndingRepository endingRepository;

    public EndingService(EndingRepository endingRepository) {
        this.endingRepository = endingRepository;
    }

    public EndingDTO getEndingById(int id){
        return endingRepository.findById(id).map(EndingDTO::new).orElse(null);
    }

    public List<EndingDTO> endingList(){
        List<EndingEntity> allEnding = endingRepository.findAll();
        return allEnding.stream()
                .map(EndingDTO::new)
                .toList();
    }

}
