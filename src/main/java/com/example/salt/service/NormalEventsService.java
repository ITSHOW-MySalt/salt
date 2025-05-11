package com.example.salt.service;

import com.example.salt.dao.NormalEventsDAO;
import com.example.salt.dto.NormalEventsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalEventsService {
    @Autowired
    private NormalEventsDAO dao;
    public NormalEventsDTO selectById(int selectId) {
        return dao.selectById(selectId);
    }
}
