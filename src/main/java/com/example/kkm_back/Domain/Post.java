package com.example.kkm_back.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Post {
    private long post_id;
    private long post_owner_id;
    private String title;
    private String image_1;
    private String image_2;
    private String image_3;
    private String description;
    private String write_time;
    private long cost;
    private long state;
    private long type;


    public Post(long post_id, long post_owner_id, String title, String image_1, String image_2, String image_3, String description, String write_time, long cost, long state, long type) {
        this.post_id = post_id;
        this.post_owner_id = post_owner_id;
        this.title = title;
        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
        this.description = description;
        this.write_time = write_time;
        this.cost = cost;
        this.state = state;
        this.type = type;
    }
}