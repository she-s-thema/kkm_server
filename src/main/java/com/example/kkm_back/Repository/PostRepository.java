package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Domain.PostList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface PostRepository {

    @Select("SELECT * FROM Post")
    List<Post> getAll();

    @Select("(SELECT Post.*, count(heart_id) as heart, address FROM Post\n"+
            "INNER JOIN Heart H, Users U\n"+
            "WHERE H.post_id = Post.post_id\n"+
            "AND H.heart_state = 1\n"+
            "AND U.user_id = Post.post_owner_id\n"+
            "AND Post.post_owner_id in\n"+
            "(select user_id from Users where ST_DISTANCE_SPHERE(POINT(#{lon}, #{lat}),\n"+
                    "POINT(lon,lat))<=5000)\n" +
            "GROUP BY Post.post_id)\n" +
            "UNION\n"+
            "(SELECT Post.*, 0 as heart, address FROM Post\n"+
             "INNER JOIN Heart H, Users U\n"+
             "WHERE Post.post_id not in (SELECT Post.post_id FROM Post\n"+
                 "INNER JOIN Heart H\n"+
                 "WHERE H.post_id = Post.post_id\n"+
                 "GROUP BY Post.post_id)\n"+
            "AND U.user_id = Post.post_owner_id\n"+
            "AND Post.post_owner_id in\n"+
            "(select user_id from Users where ST_DISTANCE_SPHERE(POINT(#{lon}, #{lat}),\n"+
            "POINT(lon,lat))<=5000)\n" +
            "GROUP BY Post.post_id)\n"+
            "ORDER BY post_id desc LIMIT #{start}, #{end}"
)
    List<PostList> getAllWithHeart(@Param("lon") String lon, @Param("lat") String lat, @Param("start") int start, @Param("end") int end);

    @Select("select post_id,title,image_1,write_time,state from Post where post_owner_id=#{post_owner_id} order by write_time desc")
    List<Map<String,Object>> getPost(@Param ("post_owner_id") String post_owner_id);


    @Select("select * from Post where post_owner_id in (select user_id from Users where ST_DISTANCE_SPHERE(POINT(#{lon},#{lat}),POINT(lon,lat))<=5000 )order by write_time desc")
    List<Post> getTown(@Param("lon")String lon, @Param("lat")String lat);

    @Update("update Post set ${i}=#{arr} where post_id=#{post_id}")
    void uploadFile(@Param("post_id")long post_id,@Param("arr") String arr,String i);

    @Select("select P.*, (select COUNT(heart_state) from Heart where post_id = #{post_id} and heart_state = 1) as heart\n" +
            "from Post P, Heart H where P.post_id = #{post_id}\n" +
            "group by P.post_id;")
    Map<String, Object> getPostDetail(@Param ("post_id") long post_id);

    @Update("update Post\n" +
            "set state=2\n" +
            "where post_id=#{post_id}")
    void setStateTwo(@Param("post_id")long post_id);
    @Update("update Post\n" +
            "set state=3\n" +
            "where post_id=#{post_id}")
    void setStateThree(@Param("post_id")long post_id);

    @Delete("delete from Post where post_id=#{post_id}")
    void deletePost(@Param("post_id")long post_id);

    @Select("select * from Post where post_id=#{post_id}")
    Post getPostWithPostId(@Param("post_id")String post_id);
}
