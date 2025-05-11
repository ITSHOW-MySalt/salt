package com.example.salt.dao;


import com.example.salt.dto.NormalEventsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NormalEventsDAO {
    NormalEventsDTO selectById(int id);
}
