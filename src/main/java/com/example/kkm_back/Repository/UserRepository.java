package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserRepository {
    @Insert("insert into Users values (#{user_id}, #{nickname}, #{k_id}, #{k_img_url}, #{lat}, #{lon}, #{address})")
    void insertUser(User user);

    @Select("SELECT * FROM Users WHERE k_id = #{k_id}")
    Map<String, Object> isExist(long k_id);

}
