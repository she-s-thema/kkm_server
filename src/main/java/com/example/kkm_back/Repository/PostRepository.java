package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Post;
import org.apache.ibatis.annotations.*;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostRepository {
    @Insert("insert into Post values (#{post_id}, #{post_owner_id}, #{title}, #{image_1}, #{image_2}, #{image_3}, #{description}, #{write_time}, #{cost},#{lat},#{lon},#{address})")
    void insertPost(Post post);
//hi
   // @Select("SELECT * FROM Post JOIN users ON users.user_id = Post.post_owner_id")


    @Select("SELECT * FROM Post")
    List<Post> getAll();

    @Select("SELECT * FROM Post WHERE post_owner_id=#{post_owner_id}")
    List<Post> getPost(@Param ("post_owner_id") String post_owner_id);


    @Select("SELECT ST_Distance_Sphere(POINT(users.lon, users.lat),POINT(Post.lon, Post.lat)) AS distance FROM Post\n " +
            "INNER JOIN users ON users.user_id=Post.post_owner_id\n" +
            "WHERE users.user_id=#{users.user_id} AND  Post.post_id=#{Post.post_id};")
    List<Double> getLAT1(@Param("users.user_id")String user_id,@Param("Post.post_id")String post_id);//다중파라미터 고쳐야해!!


    @Select("SELECT ST_Distance_Sphere(POINT(users.lon, users.lat),POINT(Post.lon, Post.lat)) AS distance FROM Post\n " +
            "INNER JOIN users ON users.user_id=Post.post_owner_id\n" +
            "WHERE users.user_id=#{users.user_id} AND ST_Distance_Sphere(POINT(users.lon, users.lat),POINT(Post.lon, Post.lat)) <=5000;")
    List<Double> getLAT(@Param("users.user_id")String user_id);//5Km 안의 게시물 서칭
    @Select("SELECT * FROM POST INNER JOIN ON users.user_id = Post.post_owner_id WHERE users.user_id=#{users.user_id} AND ST_Distance_Sphere(POINT(users.lon, users.lat),POINT(Post.lon, Post.lat)) <=5000;")
    List<Post> getPostTown(@Param("users.user_id")String user_id);
}
