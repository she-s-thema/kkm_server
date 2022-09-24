package com.example.kkm_back.Controller;

import com.example.kkm_back.DAO.ReviewDAO;
import com.example.kkm_back.Domain.Review;
import com.example.kkm_back.Repository.ReviewRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewDAO reviewDAO;

    @ResponseBody
    @RequestMapping(value = "/review", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public long makeReview(@ModelAttribute Review review) throws Exception{
        reviewDAO.reviewInsert(review);
        return review.getReview_id();
    }
    @ResponseBody
    @RequestMapping(value = "/review/{review_id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public Review getReview(@PathVariable("review_id")long review_id)throws Exception{
        return reviewRepository.getReview(review_id);
    }
    @ResponseBody
    @RequestMapping(value = "/review/update", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public String reviewUpdate(@Param("review_id")long review_id,@Param("comment")String comment,@Param("write_time")java.sql.Timestamp write_time)throws Exception{
        reviewRepository.updateReview(review_id, comment, write_time);
        return "success";
    }
}
