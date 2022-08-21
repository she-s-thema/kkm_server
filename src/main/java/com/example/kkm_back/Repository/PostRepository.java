package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PostRepository {
    @Insert("insert into Post values (#{post_id}, #{post_owner_id}, #{image_1}, #{image_2}, #{image_3}, #{description}, #{write_time}, #{cost})")
    void insertPost(Post post);
}
