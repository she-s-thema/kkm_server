package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Heart;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

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
}