package com.example.kkm_back.DAO;

import com.example.kkm_back.Domain.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportDAO {
    public List<Report> reportList();
    public void reportInsert(Report report);
}
