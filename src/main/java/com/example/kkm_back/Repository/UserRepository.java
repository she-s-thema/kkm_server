package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository {
    @Insert("insert into users values (#{user_id}, #{nickname}, #{k_id}, #{k_img_url}, #{k_email})")
    void insertUser(User user);

    void insertXml(User user);
}
