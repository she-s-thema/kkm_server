package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Opinion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OpinionRepository {
    @Insert("insert into Opinion values(#{op_id},#{title},#{description})")
    void insertOp(Opinion opinion);
}
