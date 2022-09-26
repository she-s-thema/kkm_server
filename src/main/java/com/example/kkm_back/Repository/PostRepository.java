package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Domain.PostList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostRepository {

    @Select("SELECT * FROM Post")
    List<Post> getAll();

    @Select("(SELECT Post.post_id, Post.post_owner_id, title, image_1, image_2, image_3,\n"+
            "description, write_time, cost, state, type, count(heart_id) as heart FROM Post\n"+
            "INNER JOIN Heart H\n"+
            "WHERE H.post_id = Post.post_id\n"+
            "GROUP BY Post.post_id)\n" +
            "UNION\n"+
            "(SELECT Post.post_id, Post.post_owner_id, title, image_1, image_2, image_3,\n"+
             "description, write_time, cost, state, type, 0 as heart FROM Post\n"+
                     "INNER JOIN Heart H\n"+
                     "WHERE Post.post_id not in (SELECT Post.post_id FROM Post\n"+
                     "INNER JOIN Heart H\n"+
                     "WHERE H.post_id = Post.post_id\n"+
                     "GROUP BY Post.post_id)\n"+
            "GROUP BY Post.post_id)\n"+
            "ORDER BY post_id"
)
    List<PostList> getAllWithHeart();

    @Select("SELECT * FROM Post WHERE post_owner_id=#{post_owner_id} order by write_time desc")
    List<Post> getPost(@Param ("post_owner_id") String post_owner_id);


    @Select("select * from Post where post_owner_id in (select user_id from Users where ST_DISTANCE_SPHERE(POINT(#{lon},#{lat}),POINT(lon,lat))<=5000 )order by write_time desc")
    List<Post> getTown(@Param("lon")String lon, @Param("lat")String lat);

    @Update("update Post set ${i}=#{arr} where post_id=#{post_id}")
    void uploadFile(@Param("post_id")long post_id,@Param("arr") String arr,String i);

    @Select("SELECT * FROM Post WHERE post_id=#{post_id}")
    Post getPostID(@Param ("post_id") long post_id);

    @Update("update Post\n" +
            "set state=2\n" +
            "where post_id=#{post_id}")
    void setStateTwo(@Param("post_id")long post_id);
    @Update("update Post\n" +
            "set state=3\n" +
            "where post_id=#{post_id}")
    void setStateThree(@Param("post_id")long post_id);

}
