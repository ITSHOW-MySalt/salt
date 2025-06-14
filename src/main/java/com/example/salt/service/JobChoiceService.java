package com.example.salt.service;

import com.example.salt.dto.JobChoiceDTO;
import com.example.salt.repository.JobChoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobChoiceService {
    private final JobChoiceRepository repository;

    public List<JobChoiceDTO> getAllChoices() {
        return repository.findAll()
                .stream()
                .map(JobChoiceDTO::new)
                .collect(Collectors.toList());
    }
}
