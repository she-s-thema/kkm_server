package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Post;
import org.apache.ibatis.annotations.*;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostRepository {
    @Insert("insert into Post values (#{post_id}, #{post_owner_id}, #{image_1}, #{image_2}, #{image_3}, #{description}, #{write_time}, #{cost})")
    void insertPost(Post post);

   // @Select("SELECT * FROM Post JOIN users ON users.user_id = Post.post_owner_id")


    @Select("SELECT * FROM Post")
    List<Post> getAll();

    @Select("SELECT * FROM Post WHERE post_owner_id=${post_owner_id}")
    Post getPost(@Param ("post_owner_id") String post_owner_id);

}
