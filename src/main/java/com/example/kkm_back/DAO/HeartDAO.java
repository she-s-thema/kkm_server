package com.example.kkm_back.DAO;

import com.example.kkm_back.Domain.Heart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HeartDAO {
    public List<Heart> heartList();
    public void heartInsert(Heart heart);
}
