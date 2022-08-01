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
    @Insert("insert into users values (#{user_id}, #{nickname}, #{k_id}, #{k_img_url}, #{k_email})")
    void insertUser(User user);

    @Select("SELECT user_id FROM users")
    List<Map<String, Object>> getUsersID();

    @Select("SELECT * FROM users WHERE k_id = #{k_id}")
    Map<String, Object> isExist(long k_id);
}
