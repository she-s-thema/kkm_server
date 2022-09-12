package com.example.kkm_back.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Heart {
    private long heart_id;
    private long post_id;
    private long post_owner_id;
    private long heart_user_id;
    private long heart_state;

    public Heart(long heart_id, long post_id, long post_owner_id, long heart_user_id, long heart_state) {
        this.heart_id = heart_id;
        this.post_id = post_id;
        this.post_owner_id = post_owner_id;
        this.heart_user_id=heart_user_id;
        this.heart_state=heart_state;
    }
}
