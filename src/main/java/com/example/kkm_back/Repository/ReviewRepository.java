package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReviewRepository {
    @Select("select * from Review where review_id=#{review_id}")
    Review getReview(@Param("review_id")long review_id);
}
