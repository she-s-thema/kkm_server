package com.example.kkm_back.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Review {
    private long review_id;
    private long post_id;
    private long reviewer_id;
    private long reviewed_id;
    private long state;
    private String comment;
    private java.sql.Timestamp write_time;


    public Review(long review_id, long post_id,long reviewer_id,long reviewed_id,long state, String comment, java.sql.Timestamp write_time) {
        this.review_id=review_id;
        this.post_id=post_id;
        this.reviewer_id=reviewer_id;
        this.reviewed_id=reviewed_id;
        this.state=state;
        this.comment=comment;
        this.write_time=write_time;
    }
}
