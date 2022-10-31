package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserRepository {
    @Insert("insert into Users values (#{user_id}, #{nickname}, #{k_id}, #{k_img_url}, #{lat}, #{lon}, #{address},#{kkm})")
    void insertUser(User user);

    @Select("SELECT * FROM Users WHERE k_id = #{k_id}")
    Map<String, Object> isExist(long k_id);

    @Select("select Users.nickname,Users.k_img_url from Users\n" +
            "inner join Post on Post.post_owner_id=Users.user_id\n" +
            "where Post.post_id =#{post_id}")
    List<Map<String,Object>> getUserProfile(long post_id);


    @Select("select Users.nickname,Users.k_img_url,R.comment,R.write_time from Users\n" +
            "inner join Review R on Users.user_id = R.reviewed_id\n" +
            "where Users.user_id=#{user_id}")
    List<Map<String,Object>> getReviewInfo(long user_id);

    @Select("select lon,lat from Users where user_id=#{user_id}")
    Map<String,Double>getLonLat(@Param("user_id")String user_id);
    @Update("update Users set nickname=#{nickname},lat=#{lat},lon=#{lon},address=#{address} where user_id=#{user_id}")
    void updateUser(long user_id,String nickname,double lat,double lon, String address);

    @Update("update Users set k_img_url=#{k_img_url} where IFNULL(k_id, 0)=#{k_id}")
    void updateKImg(String k_img_url, long k_id);

    @Select("select nickname,k_img_url,address,kkm from Users where user_id=#{user_id}")
    List<Map<String,Object>> getUserInfo(@Param("user_id")long user_id);
    @Update("update Users set kkm=kkm+#{value} where user_id = #{user_id}")
    void getKKM(long user_id,int value);
}
