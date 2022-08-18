package com.example.kkm_back.Repository;


import com.example.kkm_back.Domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardRepository {

    @Insert("insert into test values (#{id}, #{title}, #{content})")
    void insertTest(Board board);
}
