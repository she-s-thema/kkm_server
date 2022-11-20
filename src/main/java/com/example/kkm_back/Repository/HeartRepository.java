package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Heart;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    int trueOrFalse(long user_id, long post_id);

    @Select("select P.post_id, P.post_owner_id, P.image_1, P.title from Heart\n" +
            "inner join Users U on Heart.heart_user_id = U.user_id\n" +
            "inner Join Post P on Heart.post_id = P.post_id\n" +
            "where U.user_id=#{user_id} and Heart.heart_state=1\n" +
            "order by time desc ")
    List<Map<String,Object>> jjamList(long user_id);

    @Select( "select H.post_id from Post\n" +
            "    inner join Heart H\n" +
            "    where Post.post_owner_id in (select user_id from Users where ST_DISTANCE_SPHERE(POINT(lon,lat),POINT(#{lon},#{lat}))<=5000) and heart_user_id=#{user_id} order by H.time desc limit 3")
    List<String> postIdListfromHeartwithfiveKilo(String user_id,double lon,double lat);
    @Select("select post_id from Heart where heart_user_id=#{user_id} order by time desc limit 3")
    List<String> postIdListfromHeart(String user_id);
    @Select("select heart_user_id from Heart where post_id=#{post_id}")
    List<String> userListfromHeart(String post_id);
}