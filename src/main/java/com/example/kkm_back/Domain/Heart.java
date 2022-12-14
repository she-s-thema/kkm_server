package com.example.kkm_back.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Heart {
    private final long heart_id;
    private final long post_id;
    private final long post_owner_id;
    private final long heart_user_id;
    private final long heart_state;
    private final java.sql.Timestamp time;

    public Heart(long heart_id, long post_id, long post_owner_id, long heart_user_id, long heart_state, java.sql.Timestamp time) {
        this.heart_id = heart_id;
        this.post_id = post_id;
        this.post_owner_id = post_owner_id;
        this.heart_user_id=heart_user_id;
        this.heart_state=heart_state;
        this.time=time;
    }
}
