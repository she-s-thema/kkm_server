package com.example.kkm_back.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
    @Select("select * from users")
    public String getUsers();
}
