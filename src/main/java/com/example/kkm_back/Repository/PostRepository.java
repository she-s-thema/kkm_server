package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostRepository {
    @Insert("insert into Post values (#{post_id},#{post_owner_id},#{title},#{image_1},#{image_2},#{image_3},#{description},#{write_time},#{cost},#{state},#{type})")
    void insertPost(Post post);
//hi
   // @Select("SELECT * FROM Post JOIN users ON users.user_id = Post.post_owner_id")


    @Select("SELECT * FROM Post")
    List<Post> getAll();

    @Select("SELECT * FROM Post WHERE post_owner_id=#{post_owner_id}")
    List<Post> getPost(@Param ("post_owner_id") String post_owner_id);


    @Select("select * from Post where post_owner_id in (select user_id from Users where ST_DISTANCE_SPHERE(POINT(#{lon},#{lat}),POINT(lon,lat))<=5000 )order by write_time desc")
    List<Post> getTown(@Param("lon")String lon, @Param("lat")String lat);

    @Update("update Post set ${i}=#{arr} where post_id=#{post_id}")
    void uploadFile(@Param("post_id")long post_id,@Param("arr") String arr,String i);

    @Select("SELECT * FROM Post WHERE post_id=#{post_id}")
    Post getPostID(@Param ("post_id") long post_id);

}
