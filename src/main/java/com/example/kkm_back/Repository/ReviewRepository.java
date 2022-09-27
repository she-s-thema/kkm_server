package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ReviewRepository {
    @Select("select * from Review where review_id=#{review_id}")
    Review getReview(@Param("review_id")long review_id);
    @Update("update Review set comment=#{comment},write_time=#{write_time} where review_id=#{review_id}")
    void updateReview(@Param("review_id")long review_id,@Param("comment")String comment,@Param("write_time")java.sql.Timestamp write_time);
    @Select("select Review.comment,Review.reviewer_id,Review.write_time,U.nickname,U.k_img_url,P.image_1,P.title,P.post_id FROM Review\n" +
            "inner join Users U on Review.reviewer_id = U.user_id\n" +
            "inner join Post P on Review.post_id = P.post_id\n"+
            "where reviewed_id=#{reviewed_id}")
    List<Map<String,Object>> getReviewInfo(@Param("reviewed_id")long reviewed_id);
    }


