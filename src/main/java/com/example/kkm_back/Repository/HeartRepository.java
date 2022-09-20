package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Heart;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HeartRepository {

    @Select("select COUNT(H.heart_id) from Post\n" +
            "inner join Heart H on Post.post_id = H.post_id\n" +
            "where Post.post_id=#{post_id} and heart_state=1")
    int getHeartCount(long post_id);

    @Update("Update Post\n" +
            "inner join Heart H on Post.post_id = H.post_id\n" +
            "set H.heart_state=2\n" +
            "where H.heart_id=#{heart_id}")
    void CancelHeart(long heart_id);
    @Update("Update Post\n" +
            "inner join Heart H on Post.post_id = H.post_id\n" +
            "set H.heart_state=1\n" +
            "where H.heart_id=#{heart_id}")
    void ReHeart(long heart_id);
    @Select("select * from Heart")
    List<Heart> getAllHeart();

    @Select("\n" +
            "select COUNT(*)\n" +
            "from Heart\n" +
            "inner join Post on Heart.post_id = Post.post_id\n" +
            "inner join Users on Heart.heart_user_id = Users.user_id\n" +
            "where Users.user_id=#{user_id} and Post.post_id=#{post_id}")
    int trueOrFalse(long user_id,long post_id);
}