package com.example.kkm_back.DAO;

import com.example.kkm_back.Domain.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewDAO {
    public List<Review> reviewList();
    public void reviewInsert(Review review);
}
